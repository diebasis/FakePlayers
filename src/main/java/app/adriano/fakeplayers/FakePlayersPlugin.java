package app.adriano.fakeplayers;

// Importações necessárias para manipulação de texto e cores no console
import app.adriano.fakeplayers.commands.InfoCommand;
import app.adriano.fakeplayers.commands.PingCommand;
import app.adriano.fakeplayers.commands.ReloadCommand;
import app.adriano.fakeplayers.config.ConfigManager;
import app.adriano.fakeplayers.listeners.TestListener;
import net.kyori.adventure.text.Component;  // Classe principal para manipulação de texto
import net.kyori.adventure.text.format.NamedTextColor;  // Classe para cores predefinidas
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;  // Classe base para plugins do Bukkit/Paper

/**
 * Classe principal do plugin FakePlayers.
 * Esta classe é responsável por inicializar e gerenciar o plugin.
 * Ela estende JavaPlugin, que é a classe base para plugins do Bukkit/Paper.
 * 
 * A classe é marcada como 'final' para evitar que seja estendida por outras classes,
 * garantindo que seja a única implementação do plugin.
 * 
 * @see org.bukkit.plugin.java.JavaPlugin
 * @see app.adriano.fakeplayers.commands.InfoCommand
 * @see app.adriano.fakeplayers.commands.PingCommand
 */
public final class FakePlayersPlugin extends JavaPlugin {

    private TestListener testListener;
    private ConfigManager configManager;

    /**
     * Método chamado quando o plugin é habilitado.
     * Este método é executado quando o servidor inicia ou quando o plugin é recarregado.
     * Aqui você deve inicializar todas as funcionalidades do plugin.
     * 
     * O método é sobrescrito (@Override) da classe JavaPlugin e é chamado automaticamente
     * pelo servidor quando o plugin é carregado.
     * 
     * Fluxo de execução:
     * 1. Registra os comandos do plugin
     * 2. Configura as mensagens de console
     * 3. Inicializa outras funcionalidades (futuro)
     * 
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable() {
        // Inicializa o gerenciador de configuração
        configManager = new ConfigManager(this);
        configManager.debug("ConfigManager inicializado");
        
        // Registra o listener de teste
        testListener = new TestListener(this);
        testListener.register();
        configManager.debug("TestListener registrado");
        
        // Registra os comandos do plugin
        CommandExecutor executor = (sender, command, label, args) -> {
            configManager.debug("Comando recebido: /" + label + " " + String.join(" ", args));
            
            if (args.length == 0) {
                sender.sendMessage(Component.text("Uso: /fp [info|ping|reload]", NamedTextColor.RED));
                return true;
            }
            
            switch (args[0].toLowerCase()) {
                case "info":
                    configManager.debug("Executando comando info");
                    return new InfoCommand(this).onCommand(sender, command, label, args);
                case "ping":
                    configManager.debug("Executando comando ping");
                    return new PingCommand(this).onCommand(sender, command, label, args);
                case "reload":
                    configManager.debug("Executando comando reload");
                    return new ReloadCommand(this).onCommand(sender, command, label, args);
                default:
                    sender.sendMessage(Component.text("Subcomando desconhecido. Use: /fp [info|ping|reload]", NamedTextColor.RED));
                    return true;
            }
        };
        
        TabCompleter completer = (sender, command, alias, args) -> {
            if (args.length == 1) {
                return java.util.Arrays.asList("info", "ping", "reload");
            }
            return java.util.Collections.emptyList();
        };
        
        getServer().getCommandMap().register("fakeplayers", new Command("fp") {
            @Override
            public boolean execute(CommandSender sender, String label, String[] args) {
                return executor.onCommand(sender, this, label, args);
            }
            
            @Override
            public java.util.List<String> tabComplete(CommandSender sender, String alias, String[] args) {
                return completer.onTabComplete(sender, this, alias, args);
            }
        });
        
        // Mensagem de inicialização
        String version = getPluginMeta().getVersion();
        String enabledMessage = configManager.getString("messages.console.enabled", "&aFakePlayers v%version% carregado com sucesso!")
            .replace("%version%", version);
        
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
        
        getServer().getConsoleSender().sendMessage(
            Component.text(enabledMessage)
                    .color(NamedTextColor.GREEN)
        );
        
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
    }

    /**
     * Método chamado quando o plugin é desabilitado.
     * Este método é executado quando o servidor é desligado ou quando o plugin é recarregado.
     * Aqui você deve salvar dados e limpar recursos.
     * 
     * O método é sobrescrito (@Override) da classe JavaPlugin e é chamado automaticamente
     * pelo servidor quando o plugin é desativado.
     * 
     * Fluxo de execução:
     * 1. Salvar dados (futuro)
     * 2. Limpar recursos (futuro)
     * 3. Cancelar tarefas agendadas (futuro)
     * 4. Desregistrar listeners (futuro)
     * 
     * @see org.bukkit.plugin.java.JavaPlugin#onDisable()
     */
    @Override
    public void onDisable() {
        if (testListener != null) {
            testListener.unregister();
        }
        
        String version = getPluginMeta().getVersion();
        String disabledMessage = configManager.getString("messages.console.disabled", "&aFakePlayers v%version% desativado com sucesso!")
            .replace("%version%", version);
        
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
        
        getServer().getConsoleSender().sendMessage(
            Component.text(disabledMessage)
                    .color(NamedTextColor.GREEN)
        );
        
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
    }

    /**
     * Obtém o gerenciador de configuração do plugin.
     * 
     * @return ConfigManager com as configurações do plugin
     */
    public ConfigManager getConfigManager() {
        return configManager;
    }
}
