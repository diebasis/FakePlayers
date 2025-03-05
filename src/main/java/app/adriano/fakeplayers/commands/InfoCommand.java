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
 * O comando:
 * - Mostra o nome do plugin
 * - Mostra a versão atual
 * - Lista os autores
 * - Exibe a descrição
 * 
 * Este comando é útil para:
 * 1. Verificar a versão instalada
 * 2. Confirmar se o plugin está funcionando
 * 3. Obter informações básicas do plugin
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
     * @see app.adriano.fakeplayers.FakePlayersPlugin
     */
    private final FakePlayersPlugin plugin;

    /**
     * Construtor do comando.
     * 
     * @param plugin Instância principal do plugin
     */
    public InfoCommand(FakePlayersPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Método chamado quando o comando é executado.
     * Cria e envia uma mensagem formatada com as informações do plugin.
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
        // getPluginMeta() - Retorna as informações do plugin
        // getName() - Nome do plugin
        // getVersion() - Versão atual
        // getAuthors() - Lista de autores
        // getDescription() - Descrição do plugin
        var meta = plugin.getPluginMeta();
        
        // Cria uma mensagem formatada com as informações
        // Component.text() - Cria um novo componente de texto
        // append() - Adiciona mais texto ao componente
        // color() - Define a cor do texto
        // build() - Finaliza a construção do componente
        Component message = Component.text()
            .append(Component.text("FakePlayers ", NamedTextColor.GREEN))
            .append(Component.text("v" + meta.getVersion() + "\n", NamedTextColor.WHITE))
            .append(Component.text("Autores: ", NamedTextColor.YELLOW))
            .append(Component.text(String.join(", ", meta.getAuthors()) + "\n", NamedTextColor.WHITE))
            .append(Component.text("Descrição: ", NamedTextColor.YELLOW))
            .append(Component.text(meta.getDescription(), NamedTextColor.WHITE))
            .build();

        // Envia a mensagem para quem executou o comando
        sender.sendMessage(message);
        return true;
    }

    /**
     * Método chamado quando o jogador pressiona TAB para completar o comando.
     * Este comando não tem sugestões de tab completion.
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