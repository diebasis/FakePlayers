package app.adriano.fakeplayers.config;

import app.adriano.fakeplayers.FakePlayersPlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

/**
 * Gerenciador de configuração do plugin FakePlayers.
 * Esta classe é responsável por carregar, salvar e gerenciar as configurações do plugin.
 * 
 * Funcionalidades:
 * 1. Carrega e salva configurações do arquivo config.yml
 * 2. Converte códigos de cores (&a, &b, etc) para formato do Minecraft
 * 3. Sistema de debug integrado para diagnóstico
 * 4. Recarregamento de configurações em tempo real
 * 
 * Exemplo de uso:
 * ```java
 * // Obtém uma mensagem com cores
 * String message = configManager.getString("messages.info", "&aOlá!");
 * 
 * // Usa o sistema de debug
 * configManager.debug("Inicializando componente...");
 * ```
 * 
 * @version 0.1.4
 * @since 0.1.0
 * @see org.bukkit.configuration.file.FileConfiguration
 * @see org.bukkit.ChatColor
 */
public class ConfigManager {
    private final FakePlayersPlugin plugin;
    private FileConfiguration config;
    private File configFile;

    /**
     * Construtor do gerenciador de configuração.
     * Inicializa o sistema de configuração e carrega o arquivo config.yml.
     * 
     * @param plugin Instância principal do plugin
     */
    public ConfigManager(FakePlayersPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    /**
     * Carrega as configurações do arquivo config.yml.
     * Se o arquivo não existir, cria um novo com as configurações padrão.
     * 
     * Processo:
     * 1. Verifica se o arquivo existe
     * 2. Carrega configurações do arquivo
     * 3. Aplica configurações padrão se necessário
     */
    public void loadConfig() {
        // Cria o arquivo de configuração se não existir
        plugin.saveDefaultConfig();
        
        // Carrega o arquivo de configuração
        configFile = new File(plugin.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
        
        // Carrega as configurações padrão do arquivo interno
        InputStream defaultStream = plugin.getResource("config.yml");
        if (defaultStream != null) {
            config.setDefaults(YamlConfiguration.loadConfiguration(
                new InputStreamReader(defaultStream, StandardCharsets.UTF_8)));
        }
    }

    /**
     * Salva as configurações atuais no arquivo config.yml.
     * 
     * @return true se o salvamento foi bem-sucedido
     */
    public boolean saveConfig() {
        try {
            config.save(configFile);
            return true;
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Não foi possível salvar config.yml!", e);
            return false;
        }
    }

    /**
     * Recarrega as configurações do arquivo config.yml.
     * 
     * @return true se o recarregamento foi bem-sucedido
     */
    public boolean reloadConfig() {
        try {
            config = YamlConfiguration.loadConfiguration(configFile);
            InputStream defaultStream = plugin.getResource("config.yml");
            if (defaultStream != null) {
                config.setDefaults(YamlConfiguration.loadConfiguration(
                    new InputStreamReader(defaultStream, StandardCharsets.UTF_8)));
            }
            return true;
        } catch (Exception e) {
            plugin.getLogger().log(Level.SEVERE, "Não foi possível recarregar config.yml!", e);
            return false;
        }
    }

    /**
     * Obtém a instância da configuração.
     * 
     * @return FileConfiguration com as configurações atuais
     */
    public FileConfiguration getConfig() {
        return config;
    }

    /**
     * Obtém um valor booleano da configuração.
     * 
     * @param path Caminho do valor na configuração
     * @param defaultValue Valor padrão caso não encontre
     * @return Valor booleano da configuração
     */
    public boolean getBoolean(String path, boolean defaultValue) {
        return config.getBoolean(path, defaultValue);
    }

    /**
     * Obtém um valor inteiro da configuração.
     * 
     * @param path Caminho do valor na configuração
     * @param defaultValue Valor padrão caso não encontre
     * @return Valor inteiro da configuração
     */
    public int getInt(String path, int defaultValue) {
        return config.getInt(path, defaultValue);
    }

    /**
     * Obtém uma string da configuração com suporte a cores.
     * Converte automaticamente códigos de cores (&a, &b, etc) para o formato do Minecraft.
     * 
     * Códigos suportados:
     * - Cores básicas: &0 a &9
     * - Cores extras: &a a &f
     * - Formatação: &l (negrito), &n (sublinhado), etc
     * 
     * @param path Caminho do valor na configuração
     * @param defaultValue Valor padrão caso não encontre
     * @return String formatada com cores convertidas
     */
    public String getString(String path, String defaultValue) {
        String value = config.getString(path, defaultValue);
        return ChatColor.translateAlternateColorCodes('&', value);
    }

    /**
     * Define um valor na configuração.
     * 
     * @param path Caminho do valor na configuração
     * @param value Valor a ser definido
     */
    public void set(String path, Object value) {
        config.set(path, value);
    }

    /**
     * Envia uma mensagem de debug para o console.
     * Só exibe a mensagem se debug: true no config.yml
     * 
     * Formato da mensagem:
     * [FakePlayers] [DEBUG] mensagem
     * 
     * @param message Mensagem a ser enviada
     */
    public void debug(String message) {
        if (getBoolean("general.debug", false)) {
            plugin.getLogger().info("[DEBUG] " + message);
        }
    }
} 