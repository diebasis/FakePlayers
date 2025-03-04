package app.adriano.fakeplayers;

// Importações necessárias para manipulação de texto e cores no console
import net.kyori.adventure.text.Component;  // Classe principal para manipulação de texto
import net.kyori.adventure.text.format.NamedTextColor;  // Classe para cores predefinidas
import org.bukkit.plugin.java.JavaPlugin;  // Classe base para plugins do Bukkit/Paper

/**
 * Classe principal do plugin FakePlayers.
 * Esta classe é responsável por inicializar e gerenciar o plugin.
 * Ela estende JavaPlugin, que é a classe base para plugins do Bukkit/Paper.
 * 
 * A classe é marcada como 'final' para evitar que seja estendida por outras classes,
 * garantindo que seja a única implementação do plugin.
 */
public final class FakePlayersPlugin extends JavaPlugin {

    /**
     * Método chamado quando o plugin é habilitado.
     * Este método é executado quando o servidor inicia ou quando o plugin é recarregado.
     * Aqui você deve inicializar todas as funcionalidades do plugin.
     * 
     * O método é sobrescrito (@Override) da classe JavaPlugin e é chamado automaticamente
     * pelo servidor quando o plugin é carregado.
     */
    @Override
    public void onEnable() {
        // TODO: Implementar lógica de inicialização
        // 1. Carregar configurações
        // 2. Registrar comandos
        // 3. Registrar listeners
        // 4. Inicializar gerenciadores
        // 5. Carregar dados salvos
        
        // Mensagem de inicialização
        // getServer() - Obtém a instância do servidor
        // getConsoleSender() - Obtém o sender do console (para enviar mensagens)
        // sendMessage() - Envia uma mensagem para o console
        // Component.text() - Cria um novo componente de texto
        // color() - Define a cor do texto
        // NamedTextColor.GREEN - Cor verde predefinida
        
        // Linha decorativa superior
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
        
        // Mensagem principal com a versão do plugin
        // getPluginMeta() - Obtém as informações do plugin (versão, nome, etc)
        // getVersion() - Obtém a versão atual do plugin
        getServer().getConsoleSender().sendMessage(
            Component.text("FakePlayers v" + getPluginMeta().getVersion() + " carregado com sucesso!")
                    .color(NamedTextColor.GREEN)
        );
        
        // Linha decorativa inferior
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
     */
    @Override
    public void onDisable() {
        // TODO: Implementar lógica de desativação
        // 1. Salvar dados
        // 2. Limpar recursos
        // 3. Cancelar tarefas agendadas
        // 4. Desregistrar listeners
        
        // Mensagem de desativação
        // Utiliza os mesmos métodos do onEnable para manter consistência visual
        // A única diferença é o texto da mensagem que indica desativação
        
        // Linha decorativa superior
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
        
        // Mensagem principal com a versão do plugin
        getServer().getConsoleSender().sendMessage(
            Component.text("FakePlayers v" + getPluginMeta().getVersion() + " desativado com sucesso!")
                    .color(NamedTextColor.GREEN)
        );
        
        // Linha decorativa inferior
        getServer().getConsoleSender().sendMessage(
            Component.text("=============================================")
                    .color(NamedTextColor.GREEN)
        );
    }
}
