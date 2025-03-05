package app.adriano.fakeplayers.commands;

import app.adriano.fakeplayers.FakePlayersPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Comando que exibe informações sobre o plugin FakePlayers.
 * Este comando é executado quando um jogador ou o console usa o comando /fp info
 * 
 * O comando mostra:
 * - Nome do plugin
 * - Versão atual
 * - Autores
 * - Descrição
 */
public class InfoCommand implements CommandExecutor, TabCompleter {
    
    private final FakePlayersPlugin plugin;

    /**
     * Construtor do comando.
     * @param plugin Instância principal do plugin
     */
    public InfoCommand(FakePlayersPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Método chamado quando o comando é executado.
     * @param sender Quem executou o comando (jogador ou console)
     * @param command O comando que foi executado
     * @param label O alias usado para executar o comando
     * @param args Argumentos passados ao comando
     * @return true se o comando foi executado com sucesso
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Cria uma mensagem formatada com as informações do plugin
        Component message = Component.text()
            .append(Component.text("=== FakePlayers Info ===\n", NamedTextColor.GREEN))
            .append(Component.text("Versão: ", NamedTextColor.YELLOW))
            .append(Component.text(plugin.getPluginMeta().getVersion() + "\n", NamedTextColor.WHITE))
            .append(Component.text("Autores: ", NamedTextColor.YELLOW))
            .append(Component.text(String.join(", ", plugin.getPluginMeta().getAuthors()) + "\n", NamedTextColor.WHITE))
            .append(Component.text("Descrição: ", NamedTextColor.YELLOW))
            .append(Component.text(plugin.getPluginMeta().getDescription() + "\n", NamedTextColor.WHITE))
            .append(Component.text("=====================", NamedTextColor.GREEN))
            .build();

        // Envia a mensagem para quem executou o comando
        sender.sendMessage(message);
        return true;
    }

    /**
     * Método chamado quando o jogador pressiona TAB para completar o comando.
     * @param sender Quem está tentando completar o comando
     * @param command O comando que está sendo completado
     * @param alias O alias usado para o comando
     * @param args Os argumentos já digitados
     * @return Lista de sugestões para completar o comando
     */
    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Este comando não tem sugestões de tab completion
        return java.util.Collections.emptyList();
    }
} 