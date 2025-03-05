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
 * Implementação:
 * 1. Armazena o timestamp da última execução
 * 2. Calcula o tempo de resposta atual
 * 3. Formata a mensagem com cores diferentes
 * 4. Envia a resposta ao jogador
 * 
 * Detalhes Técnicos:
 * - Usa System.currentTimeMillis() para precisão em milissegundos
 * - Implementa CommandExecutor para processar o comando
 * - Implementa TabCompleter para sugestões (não utilizado)
 * - Utiliza Adventure API para formatação de texto
 * 
 * @see org.bukkit.command.CommandExecutor
 * @see org.bukkit.command.TabCompleter
 */
public class PingCommand implements CommandExecutor, TabCompleter {
    
    /**
     * Armazena o timestamp da última execução do comando.
     * É usado para calcular o tempo de resposta entre chamadas.
     * 
     * Implementação:
     * - Inicializado no construtor
     * - Atualizado a cada execução
     * - Usado para calcular latência
     * 
     * @see System#currentTimeMillis()
     */
    private long lastPingTime;

    /**
     * Construtor do comando.
     * Inicializa o timestamp da última execução com o tempo atual.
     * 
     * Implementação:
     * - Chama super() para inicializar a classe base
     * - Define lastPingTime com o tempo atual
     * - Prepara o comando para primeira execução
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
     * Implementação:
     * 1. Obtém o tempo atual
     * 2. Calcula a diferença com o último ping
     * 3. Atualiza o timestamp
     * 4. Formata e envia a mensagem
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