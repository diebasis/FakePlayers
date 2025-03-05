package app.adriano.fakeplayers.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Comando que testa a latência do plugin.
 * Este comando é executado quando um jogador ou o console usa o comando /fp ping
 * 
 * O comando:
 * - Responde com "pong"
 * - Mostra o tempo de resposta em milissegundos
 * - Usa cores diferentes para melhor visualização
 * 
 * Este comando é útil para:
 * 1. Testar se o plugin está respondendo
 * 2. Medir a latência do servidor
 * 3. Verificar se há problemas de performance
 * 
 * @see org.bukkit.command.CommandExecutor
 * @see org.bukkit.command.TabCompleter
 */
public class PingCommand implements CommandExecutor, TabCompleter {
    
    /**
     * Armazena o timestamp da última execução do comando.
     * É usado para calcular o tempo de resposta entre chamadas.
     * 
     * @see System#currentTimeMillis()
     */
    private long lastPingTime;

    /**
     * Construtor do comando.
     * Inicializa o timestamp da última execução com o tempo atual.
     * 
     * @see System#currentTimeMillis()
     */
    public PingCommand() {
        this.lastPingTime = System.currentTimeMillis();
    }

    /**
     * Método chamado quando o comando é executado.
     * Calcula o tempo de resposta e envia uma mensagem formatada.
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
        // Calcula o tempo de resposta
        long currentTime = System.currentTimeMillis();
        long responseTime = currentTime - lastPingTime;
        lastPingTime = currentTime;

        // Cria uma mensagem formatada com o resultado do ping
        // Component.text() - Cria um novo componente de texto
        // append() - Adiciona mais texto ao componente
        // color() - Define a cor do texto
        // build() - Finaliza a construção do componente
        Component message = Component.text()
            .append(Component.text("Pong! ", NamedTextColor.GREEN))
            .append(Component.text("Tempo de resposta: ", NamedTextColor.YELLOW))
            .append(Component.text(responseTime + "ms", NamedTextColor.WHITE))
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