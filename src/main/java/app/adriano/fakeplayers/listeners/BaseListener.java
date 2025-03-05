package app.adriano.fakeplayers.listeners;

import app.adriano.fakeplayers.FakePlayersPlugin;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Classe base para todos os listeners do plugin.
 * 
 * Esta classe:
 * 1. Fornece acesso à instância principal do plugin
 * 2. Implementa métodos comuns para todos os listeners
 * 3. Facilita o registro e desregistro de eventos
 * 
 * @see org.bukkit.event.Listener
 * @see app.adriano.fakeplayers.FakePlayersPlugin
 */
public abstract class BaseListener implements Listener {
    
    /**
     * Instância principal do plugin.
     * 
     * @see app.adriano.fakeplayers.FakePlayersPlugin
     */
    protected final FakePlayersPlugin plugin;

    /**
     * Construtor do listener.
     * 
     * @param plugin Instância principal do plugin
     */
    protected BaseListener(FakePlayersPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Registra este listener no servidor.
     * Este método deve ser chamado quando o plugin é habilitado.
     */
    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Desregistra este listener do servidor.
     * Este método deve ser chamado quando o plugin é desabilitado.
     */
    public void unregister() {
        HandlerList.unregisterAll(this);
    }
} 