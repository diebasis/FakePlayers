# FakePlayers

Um plugin para Minecraft Paper que permite criar Fake Players no servidor.

## 📋 Descrição

FakePlayers é um plugin que permite criar Fake Players no seu servidor Minecraft. Esses jogadores podem ser usados para diversos propósitos, como:
- Simular atividade no servidor
- Testar plugins e sistemas
- Criar ambientes mais realistas
- E muito mais!

## 📚 Documentação

Para documentação técnica detalhada, incluindo guias de desenvolvimento, boas práticas e referências, consulte [Documentação Técnica](docs/TECHNICAL.md).

## 🚀 Comandos

- `/fp info` - Exibe informações sobre o plugin
- `/fp ping` - Testa a latência do servidor
- `/fp reload` - Recarrega as configurações do plugin

## 🔑 Permissões

- `fakeplayers.use` - Permissão base para usar comandos
- `fakeplayers.info` - Permissão para usar o comando info
- `fakeplayers.ping` - Permissão para usar o comando ping
- `fakeplayers.reload` - Permissão para recarregar configurações

## 📦 Instalação

1. Baixe o arquivo `FakePlayers-0.1.2.jar` da última versão.
2. Coloque o arquivo na pasta `plugins` do seu servidor Minecraft.
3. Reinicie o servidor para carregar o plugin.

## 📖 Exemplos de Uso

### Comandos

#### /fp info
Exibe informações detalhadas sobre o plugin, incluindo:
- Versão atual
- Autores
- Descrição
- Status do plugin

Exemplo:
```
/fp info
```

#### /fp ping
Testa a latência do servidor e do plugin, mostrando:
- Tempo de resposta em milissegundos
- Status do servidor
- Performance do plugin

Exemplo:
```
/fp ping
```

### Listeners

#### TestListener
Registra quando um jogador entra no servidor, útil para:
- Monitoramento de atividade
- Testes de integração
- Debug de problemas

## 🛠️ Troubleshooting

### Problemas Comuns

1. **Plugin não carrega**
   - Verifique se o arquivo .jar está na pasta plugins
   - Confirme se está usando a versão correta do Paper
   - Verifique os logs do servidor para mais detalhes

2. **Comandos não funcionam**
   - Confirme se tem a permissão `fakeplayers.use`
   - Verifique se o plugin está ativo com `/fp info`
   - Reinicie o servidor se necessário

3. **Erros de Performance**
   - Use `/fp ping` para verificar latência
   - Monitore o uso de recursos do servidor
   - Verifique se há conflitos com outros plugins

## 📝 Changelog

### Versão 0.1.4
- Sistema de Configuração
  - Implementado ConfigManager completo
  - Adicionado comando `/fp reload`
  - Suporte a recarregamento de configurações em tempo real
  - Mensagens configuráveis via `config.yml`
- Sistema de Cores
  - Suporte completo a códigos de cores do Minecraft
  - Conversão automática de `&` para `§`
  - Documentação detalhada dos códigos de cores
  - Todas as mensagens agora suportam formatação
- Sistema de Debug
  - Nova opção `general.debug` no `config.yml`
  - Logs detalhados de inicialização
  - Monitoramento de execução de comandos
  - Rastreamento de eventos importantes
- Melhorias na Documentação
  - Documentação técnica expandida
  - Guias de usuário atualizados
  - Exemplos de uso adicionados
  - Melhor consistência entre arquivos
- Estrutura e Correções
  - Reorganização do código
  - Padronização de mensagens
  - Melhorias na formatação
  - Correções de bugs menores

### Versão 0.1.3
- Sistema de Listeners
  - Corrigido problema de duplicação de mensagens no TestListener
  - Removido SimpleTestListener não utilizado
  - Implementada classe base BaseListener
  - Adicionado sistema de registro/desregistro automático
- Melhorias nas Mensagens
  - Padronização do formato das mensagens
  - Implementação inicial do sistema de cores
  - Melhor feedback para usuários
- Documentação
  - Adicionada documentação JavaDoc em todas as classes
  - Criado arquivo TECHNICAL.md com detalhes técnicos
  - Atualizado README com novos comandos e funcionalidades

### Versão 0.1.2
- Sistema de Comandos
  - Implementado comando `/fp info` com informações detalhadas
  - Implementado comando `/fp ping` para teste de latência
  - Adicionado sistema de permissões por comando
  - Implementado TabCompleter para sugestões
- Estrutura do Plugin
  - Organização em pacotes (commands, listeners, etc)
  - Implementação do padrão Command
  - Sistema básico de eventos
- Documentação
  - Documentação inicial do código
  - Guia de instalação
  - Instruções de uso dos comandos

### Versão 0.1.1
- Estrutura Inicial
  - Criação do projeto base
  - Configuração do ambiente Gradle
  - Definição da estrutura de pacotes
- Sistema Base
  - Implementação da classe principal FakePlayersPlugin
  - Sistema básico de comandos
  - Configuração inicial do plugin.yml
- Documentação
  - README básico
  - Instruções de compilação
  - Requisitos do sistema

## Roadmap

### Versão 0.1.x
- [x] Estrutura básica do plugin
- [x] Comandos básicos
- [x] Listener básico (TestListener)
- [x] Correções e melhorias
- [x] Sistema de configuração

### Versão 0.2.x
- [ ] Criação de Fake Players
- [ ] Personalização de aparência
- [ ] Comportamentos básicos

### Versão 0.3.x
- [ ] Sistema de IA
- [ ] Interações complexas
- [ ] API pública

## 💻 Desenvolvimento

### Requisitos
- Java 17 ou superior
- Gradle
- Paper API

### Dependências e Importações
Para entender todas as dependências e importações utilizadas no projeto, consulte a [seção de Importações](docs/TECHNICAL.md#importações-do-projeto) na documentação técnica.

### Compilando o projeto

```bash
# Clone o repositório
git clone https://github.com/diebasis/FakePlayers.git

# Entre na pasta do projeto
cd FakePlayers

# Compile o projeto
./gradlew build
```

O arquivo `.jar` será gerado em `build/libs/`

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Por favor, leia o [CONTRIBUTING.md](CONTRIBUTING.md) para detalhes sobre nosso código de conduta e o processo para enviar pull requests.

## 📞 Suporte

Se você encontrar algum problema ou tiver sugestões, por favor abra uma issue no GitHub.

## 👥 Autores

* **Adriano Vargas** - *Desenvolvimento inicial* - [diebasis](https://github.com/diebasis)

## 🙏 Agradecimentos

* PaperMC Team pelo excelente servidor e API
* Todos os contribuidores que ajudarem no projeto 

## Características
- Sistema de comandos integrado
- Configuração flexível via `config.yml`
- Sistema de cores para mensagens
- Modo debug para diagnóstico
- Permissões customizáveis

## Configuração
O arquivo `config.yml` permite personalizar:
- Mensagens do plugin (com suporte a cores)
- Modo debug para diagnóstico
- Permissões dos comandos
- Intervalos de atualização

### Cores
O plugin suporta códigos de cores do Minecraft:
```
&0 até &9 - Cores básicas
&a até &f - Cores extras
&l - Negrito
&n - Sublinhado
&o - Itálico
&k - Texto embaralhado
&m - Riscado
&r - Remove formatação
```

### Debug
Ative o modo debug no `config.yml`:
```yaml
general:
  debug: true
```
Isso mostrará logs detalhados no console. 