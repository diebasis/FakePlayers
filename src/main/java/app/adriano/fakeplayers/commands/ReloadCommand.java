package app.adriano.fakeplayers.commands;

import app.adriano.fakeplayers.FakePlayersPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Comando para recarregar as configurações do plugin.
 * Este comando é executado quando um jogador ou o console usa o comando /fp reload
 * 
 * Funcionalidades:
 * 1. Recarrega o arquivo config.yml
 * 2. Atualiza as configurações em memória
 * 3. Notifica o usuário sobre o resultado
 * 
 * @see org.bukkit.command.CommandExecutor
 * @see org.bukkit.command.TabCompleter
 */
public class ReloadCommand implements CommandExecutor, TabCompleter {
    private final FakePlayersPlugin plugin;

    /**
     * Construtor do comando.
     * 
     * @param plugin Instância principal do plugin
     */
    public ReloadCommand(FakePlayersPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Método chamado quando o comando é executado.
     * Recarrega as configurações e notifica o usuário.
     * 
     * @param sender Quem executou o comando (jogador ou console)
     * @param command O comando que foi executado
     * @param label O alias usado para executar o comando
     * @param args Argumentos passados ao comando
     * @return true se o comando foi executado com sucesso
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Recarrega as configurações
        boolean success = plugin.getConfigManager().reloadConfig();
        
        // Obtém a mensagem do config
        String message = plugin.getConfigManager().getString(
            "messages.commands.reload", 
            success ? "&aConfigurações recarregadas com sucesso!" : "&cErro ao recarregar configurações!"
        );
        
        // Envia a mensagem formatada
        sender.sendMessage(Component.text(message));
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
     */
    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return java.util.Collections.emptyList();
    }
} 