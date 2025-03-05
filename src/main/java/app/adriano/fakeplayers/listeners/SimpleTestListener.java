package app.adriano.fakeplayers.listeners;

import app.adriano.fakeplayers.FakePlayersPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Listener de teste simples para verificar a funcionalidade básica dos listeners.
 * 
 * @see org.bukkit.event.Listener
 * @see app.adriano.fakeplayers.FakePlayersPlugin
 */
public class SimpleTestListener implements Listener {
    
    private final FakePlayersPlugin plugin;

    /**
     * Construtor do listener de teste.
     * 
     * @param plugin Instância principal do plugin
     */
    public SimpleTestListener(FakePlayersPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Manipula o evento de jogador entrar no servidor.
     * 
     * @param event O evento de jogador entrar
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getLogger().info("Jogador " + event.getPlayer().getName() + " entrou no servidor!");
    }
} 