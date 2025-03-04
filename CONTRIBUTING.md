# Guia de Contribuição

Obrigado pelo seu interesse em contribuir com o FakePlayers! Este documento fornece diretrizes e instruções para contribuir com o projeto.

## Como Contribuir

1. Faça um fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Faça commit das suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## Padrões de Código

- Use indentação de 4 espaços
- Siga as convenções de nomenclatura Java
- Comente seu código quando necessário
- Mantenha as classes e métodos pequenos e focados
- Evite código duplicado

## Estrutura do Projeto

```
src/main/java/app/adriano/fakeplayers/
├── FakePlayersPlugin.java
├── commands/
├── listeners/
├── models/
└── utils/
```

## Commit Messages

- Use o presente do indicativo ("Add feature" não "Added feature")
- Use o imperativo ("Move cursor to..." não "Moves cursor to...")
- Limite a primeira linha a 72 caracteres ou menos
- Referencie issues e pull requests livremente após a primeira linha
- Considere adicionar mais detalhes no corpo do commit

## Pull Requests

1. Atualize a documentação se necessário
2. Adicione testes para novas funcionalidades
3. Certifique-se de que todos os testes passam
4. Atualize o README.md se necessário
5. Descreva detalhadamente as mudanças no PR

## Reportando Bugs

- Use o template de issue do GitHub
- Descreva o comportamento esperado
- Descreva o comportamento atual
- Inclua logs e screenshots quando possível
- Mencione a versão do plugin e do servidor

## Perguntas?

Se você tiver dúvidas, sinta-se à vontade para abrir uma issue ou entrar em contato com os mantenedores.

## Licença

Ao contribuir, você concorda que suas contribuições serão licenciadas sob a mesma licença do projeto (MIT). 