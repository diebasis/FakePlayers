package app.adriano.fakeplayers.commands;

import app.adriano.fakeplayers.FakePlayersPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Comando que testa a latência do plugin.
 * Este comando é executado quando um jogador ou o console usa o comando /fp ping
 * 
 * @see org.bukkit.command.CommandExecutor
 * @see org.bukkit.command.TabCompleter
 */
public class PingCommand implements CommandExecutor, TabCompleter {
    private final FakePlayersPlugin plugin;
    private long lastPingTime;

    /**
     * Construtor do comando.
     * 
     * @param plugin Instância principal do plugin
     */
    public PingCommand(FakePlayersPlugin plugin) {
        this.plugin = plugin;
        this.lastPingTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Calcula o tempo de resposta
        long currentTime = System.currentTimeMillis();
        long responseTime = currentTime - lastPingTime;
        lastPingTime = currentTime;

        // Obtém a mensagem do config e substitui o placeholder
        String message = plugin.getConfigManager().getString("messages.commands.ping", "&aPong! &eTempo de resposta: &f%time%ms")
            .replace("%time%", String.valueOf(responseTime));

        // Envia a mensagem formatada
        sender.sendMessage(Component.text(message));
        return true;
    }

    @Override
    public java.util.List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return java.util.Collections.emptyList();
    }
} 