package app.adriano.fakeplayers.commands;

import app.adriano.fakeplayers.FakePlayersPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Comando que exibe informações sobre o plugin.
 * Este comando é executado quando um jogador ou o console usa o comando /fp info
 * 
 * Implementação:
 * 1. Obtém as informações do plugin via PluginMeta
 * 2. Formata as informações com cores diferentes
 * 3. Envia a mensagem formatada ao jogador
 * 
 * Detalhes Técnicos:
 * - Usa Adventure API para formatação de texto
 * - Implementa CommandExecutor para processar o comando
 * - Implementa TabCompleter para sugestões (não utilizado)
 * - Requer instância do plugin para acessar metadados
 * 
 * @see org.bukkit.command.CommandExecutor
 * @see org.bukkit.command.TabCompleter
 * @see app.adriano.fakeplayers.FakePlayersPlugin
 */
public class InfoCommand implements CommandExecutor, TabCompleter {
    
    /**
     * Instância principal do plugin.
     * Usada para acessar informações como versão, nome, etc.
     * 
     * Implementação:
     * - Inicializada no construtor
     * - Usada para acessar PluginMeta
     * - Permite acesso a configurações
     * 
     * @see app.adriano.fakeplayers.FakePlayersPlugin
     */
    private final FakePlayersPlugin plugin;

    /**
     * Construtor do comando.
     * Inicializa a instância do plugin.
     * 
     * Implementação:
     * - Recebe a instância do plugin
     * - Armazena para uso posterior
     * - Prepara o comando para execução
     * 
     * @param plugin Instância principal do plugin
     */
    public InfoCommand(FakePlayersPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Método chamado quando o comando é executado.
     * Obtém e exibe informações sobre o plugin.
     * 
     * Implementação:
     * 1. Obtém PluginMeta do plugin
     * 2. Extrai informações relevantes
     * 3. Formata a mensagem
     * 4. Envia ao jogador
     * 
     * @param sender Quem executou o comando (jogador ou console)
     * @param command O comando que foi executado
     * @param label O alias usado para executar o comando
     * @param args Argumentos passados ao comando
     * @return true se o comando foi executado com sucesso
     * 
     * @see org.bukkit.command.CommandExecutor#onCommand(CommandSender, Command, String, String[])
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Obtém as informações do plugin
        var meta = plugin.getPluginMeta();
        
        // Cria uma mensagem formatada com as informações
        Component message = Component.text()
            .append(Component.text("=============================================\n", NamedTextColor.GREEN))
            .append(Component.text("FakePlayers v" + meta.getVersion() + "\n", NamedTextColor.GREEN))
            .append(Component.text("Autores: ", NamedTextColor.YELLOW))
            .append(Component.text(String.join(", ", meta.getAuthors()) + "\n", NamedTextColor.WHITE))
            .append(Component.text("Descrição: ", NamedTextColor.YELLOW))
            .append(Component.text(meta.getDescription() + "\n", NamedTextColor.WHITE))
            .append(Component.text("=============================================", NamedTextColor.GREEN))
            .build();

        // Envia a mensagem para quem executou o comando
        sender.sendMessage(message);
        return true;
    }

    /**
     * Método chamado quando o jogador pressiona TAB para completar o comando.
     * Este comando não tem sugestões de tab completion.
     * 
     * Implementação:
     * - Retorna lista vazia pois não há sugestões
     * - Implementado para satisfazer a interface
     * 
     * @param sender Quem está tentando completar o comando
     * @param command O comando que está sendo completado
     * @param alias O alias usado para o comando
     * @param args Os argumentos já digitados
     * @return Lista vazia pois não há sugestões
     * 
     * @see org.bukkit.command.TabCompleter#onTabComplete(CommandSender, Command, String, String[])
     */
    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Este comando não tem sugestões de tab completion
        return java.util.Collections.emptyList();
    }
} 