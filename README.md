# FakePlayers

Um plugin para Minecraft Paper que permite criar jogadores falsos no servidor.

## 📋 Descrição

FakePlayers é um plugin que permite criar jogadores falsos no seu servidor Minecraft. Esses jogadores podem ser usados para diversos propósitos, como:
- Simular atividade no servidor
- Criar NPCs personalizados
- Gerar interações automáticas
- Entre outros usos criativos

## 🚀 Funcionalidades

- [ ] Criação de jogadores falsos
- [ ] Personalização de aparência
- [ ] Comportamentos programáveis
- [ ] Sistema de comandos intuitivo
- [ ] Configuração flexível

## 📦 Instalação

1. Baixe o arquivo `.jar` da última release
2. Coloque o arquivo na pasta `plugins` do seu servidor Paper
3. Reinicie o servidor

## ⚙️ Configuração

O arquivo de configuração será gerado automaticamente na primeira execução do plugin.

```yaml
# Configurações padrão
settings:
  max-fake-players: 10
  auto-spawn: false
```

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