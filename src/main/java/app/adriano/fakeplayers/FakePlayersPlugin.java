package app.adriano.fakeplayers;

// Importações necessárias para manipulação de texto e cores no console
import app.adriano.fakeplayers.commands.InfoCommand;
import app.adriano.fakeplayers.commands.PingCommand;
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
        // Registra o listener de teste
        testListener = new TestListener(this);
        testListener.register();
        
        // Registra os comandos do plugin
        // Cria e configura o comando principal
        CommandExecutor executor = (sender, command, label, args) -> {
            // Se não houver argumentos, mostra a ajuda
            if (args.length == 0) {
                sender.sendMessage(Component.text("Uso: /fp [info|ping]", NamedTextColor.RED));
                return true;
            }
            
            // Processa os subcomandos
            switch (args[0].toLowerCase()) {
                case "info":
                    return new InfoCommand(this).onCommand(sender, command, label, args);
                case "ping":
                    return new PingCommand().onCommand(sender, command, label, args);
                default:
                    sender.sendMessage(Component.text("Subcomando desconhecido. Use: /fp [info|ping]", NamedTextColor.RED));
                    return true;
            }
        };
        
        // Configura o tab completer para sugestões de comandos
        TabCompleter completer = (sender, command, alias, args) -> {
            // Retorna sugestões apenas para o primeiro argumento
            if (args.length == 1) {
                return java.util.Arrays.asList("info", "ping");
            }
            return java.util.Collections.emptyList();
        };
        
        // Registra o comando no servidor
        // Cria uma nova instância do comando com nome "fp"
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
        // Desregistra o listener de teste
        if (testListener != null) {
            testListener.unregister();
        }
        
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
