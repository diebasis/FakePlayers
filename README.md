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

## 🚀 Funcionalidades

- [ ] Criação de Fake Players
- [ ] Personalização de aparência
- [ ] Comportamentos programáveis
- [ ] Sistema de comandos intuitivo
- [ ] Configuração flexível

## 📦 Instalação

1. Baixe o arquivo `FakePlayers-0.1.2.jar` da última versão.
2. Coloque o arquivo na pasta `plugins` do seu servidor Minecraft.
3. Reinicie o servidor para carregar o plugin.

## 🔑 Permissões

- `fakeplayers.use`: Permissão base para usar comandos do plugin
- `fakeplayers.admin`: Permissão para acessar comandos administrativos (futuro)

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

### Versão 0.1.3
- Corrigido duplicação de mensagens do TestListener
- Removido SimpleTestListener não utilizado
- Melhorias na formatação das mensagens

### Versão 0.1.2
- Adicionado comando `/fp info` para exibir informações do plugin
- Adicionado comando `/fp ping` para testar a latência
- Implementado `TestListener` para registrar entradas de jogadores
- Melhorias na documentação e comentários do código

### Versão 0.1.1
- Estrutura básica do plugin
- Sistema de comandos inicial
- Documentação técnica básica

## Roadmap

### Versão 0.1.x
- [x] Estrutura básica do plugin
- [x] Comandos básicos
- [x] Listener básico (TestListener)
- [x] Correções e melhorias
- [ ] Sistema de configuração

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