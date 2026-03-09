<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - Challenge Literalura</title>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Alura](https://img.shields.io/badge/Alura-17222E?style=for-the-badge&logo=alura&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

    <style>
        body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif; line-height: 1.6; color: #24292e; max-width: 900px; margin: 0 auto; padding: 20px; }
        h1, h2, h3 { border-bottom: 1px solid #eaecef; padding-bottom: .3em; margin-top: 24px; }
        code { background-color: rgba(27,31,35,.05); border-radius: 3px; padding: .2em .4em; font-family: "SFMono-Regular", Consolas, monospace; font-size: 85%; }
        pre { background-color: #f6f8fa; border-radius: 3px; padding: 16px; overflow: auto; line-height: 1.45; }
        img { max-width: 100%; height: auto; vertical-align: middle; }
        .badges { margin-bottom: 20px; }
        .badges img { margin-right: 5px; margin-bottom: 5px; }
        .demonstracao { background-color: #0d1117; color: #c9d1d9; border-radius: 6px; padding: 16px; font-family: monospace; }
    </style>
</head>
<body>

    <h1>Challenge Literalura - Oracle Next Education</h1>


    <div class="badges">
        <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
        <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white" alt="Oracle">
        <img src="https://img.shields.io/badge/Alura-17222E?style=for-the-badge&logo=alura&logoColor=white" alt="Alura">
        <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
    </div>

    <p>Este projeto é um desafio prático proposto pelo programa <strong>ONE (Oracle Next Education)</strong> em parceria com a <strong>Alura</strong>. O objetivo é aplicar conhecimentos avançados de Java (JDK 17), Spring Boot, persistência de dados em bancos relacionais e consumo de APIs em uma aplicação de catálogo literário.</p>

    <h2>O Desafio</h2>
    <p>Desenvolver um catálogo de livros que realize o consumo da API Gutendex, processe os dados JSON e forneça uma interface interativa via console, persistindo as informações em um banco de dados PostgreSQL para consultas futuras.</p>

    <h3>Funcionalidades Implementadas:</h3>
    <ul>
        <li><strong>Busca de livros por título:</strong> Integração com API externa e persistência automática de obras e autores.</li>
        <li><strong>Listagem de livros e autores:</strong> Recuperação integral de registros armazenados no banco de dados.</li>
        <li><strong>Filtro de autores vivos:</strong> Localização de escritores ativos em anos específicos via <em>Derived Queries</em>.</li>
        <li><strong>Estatísticas por idioma:</strong> Contagem de volumes literários baseada em códigos de localidade (en, pt, es, fr).</li>
    </ul>

    <h2>Tecnologias Utilizadas</h2>
    <ul>
        <li><strong>Java 17 (LTS):</strong> Utilização de Records, Streams e tratamento de exceções robusto.</li>
        <li><strong>Spring Boot 3:</strong> Framework para gestão de dependências e inversão de controle.</li>
        <li><strong>Spring Data JPA:</strong> Abstração da camada de persistência para interação com o banco de dados.</li>
        <li><strong>PostgreSQL:</strong> Banco de dados relacional utilizado para o armazenamento persistente.</li>
        <li><strong>Jackson:</strong> Biblioteca utilizada para a desserialização de dados JSON.</li>
        <li><strong>IntelliJ IDEA Ultimate:</strong> IDE utilizada para o desenvolvimento e gestão do projeto via Maven.</li>
    </ul>

    <h2>Estrutura do Projeto</h2>
    <p>A organização segue os princípios de <strong>Clean Code</strong>, <strong>SOLID</strong> e separação de responsabilidades em camadas:</p>

    

    <ul>
        <li><code>com.alura.formacaoONE.literalura</code>: Contém a classe <code>Principal.java</code>, ponto de entrada do sistema.</li>
        <li><code>model</code>: Contém as entidades JPA (Livro, Autor) e os Records para DTOs.</li>
        <li><code>repository</code>: Interfaces para operações de CRUD e consultas personalizadas.</li>
        <li><code>service</code>: Isolamento da lógica de negócio e interface (LivroService, MenuServico).</li>
    </ul>

    <h2>Como Configurar e Rodar</h2>
    <ol>
        <li><strong>Banco de Dados:</strong> Certifique-se de ter um banco de dados PostgreSQL criado.</li>
        <li><strong>Propriedades:</strong> Configure suas credenciais no arquivo <code>application.properties</code>.</li>
        <li><strong>Execução:</strong> Inicie a aplicação através da classe <code>Principal.java</code>.</li>
    </ol>

    <h2>Demonstração de Uso</h2>
    <div class="demonstracao">
<pre>
--- MENU LITERALURA ---
1- Buscar livro | 2- Listar livros | 3- Listar autores
4- Autores vivos no ano | 5- Livros por idioma | 6- Contagem por idioma
0- Sair

Sua opção: 1
Digite o título: Dom Casmurro

Registrado: Livro [Título: Dom Casmurro | Autor: Machado de Assis | Idioma: pt | Downloads: 12500]
</pre>
    </div>

    <h2>Autor</h2>
    <p>Desenvolvido por <strong>Raphael (raphaelbr22)</strong> como conclusão do desafio Literalura na trilha Java do programa Oracle Next Education.</p>

</body>
</html>