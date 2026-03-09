# Challenge Literalura - Oracle Next Education

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Alura](https://img.shields.io/badge/Alura-17222E?style=for-the-badge&logo=alura&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

Este projeto é um desafio prático proposto pelo programa **ONE (Oracle Next Education)** em parceria com a **Alura**. O objetivo é aplicar conhecimentos avançados de Java (JDK 17), Spring Boot, persistência de dados em bancos relacionais e consumo de APIs em uma aplicação de catálogo literário.

## O Desafio
Desenvolver um catálogo de livros que realize o consumo da API Gutendex, processe os dados JSON e forneça uma interface interativa via console, persistindo as informações em um banco de dados PostgreSQL para consultas futuras.

### Funcionalidades Implementadas:
* **Busca de livros por título**: Integração com API externa e persistência automática de obras e autores.
* **Listagem de livros e autores**: Recuperação integral de registros armazenados no banco de dados.
* **Filtro de autores vivos**: Localização de escritores ativos em anos específicos via *Derived Queries*.
* **Estatísticas por idioma**: Contagem de volumes literários baseada em códigos de localidade (en, pt, es, fr).

## Tecnologias Utilizadas

* **Java 17 (LTS)**: Utilização de `Records`, `Streams` e tratamento de exceções robusto.
* **Spring Boot 3**: Framework para gestão de dependências e inversão de controle.
* **Spring Data JPA**: Abstração da camada de persistência para interação com o banco de dados.
* **PostgreSQL**: Banco de dados relacional utilizado para o armazenamento persistente.
* **Jackson**: Biblioteca utilizada para a desserialização de dados JSON.
* **IntelliJ IDEA Ultimate**: IDE utilizada para o desenvolvimento e gestão do projeto via Maven.

## Estrutura do Projeto

A organização segue os princípios de **Clean Code**, **SOLID** e separação de responsabilidades em camadas:

* `com.alura.formacaoONE.literalura`: Contém a classe `Principal.java`, ponto de entrada do sistema.
* `com.alura.formacaoONE.literalura.model`: Contém as entidades JPA (`Livro`, `Autor`) e os Records para DTOs.
* `com.alura.formacaoONE.literalura.repository`: Interfaces `ILivroRepository` e `IAutorRepository` para operações de CRUD.
* `com.alura.formacaoONE.literalura.service`: Isolamento da lógica de negócio e interface:
    * `LivroService.java`: Gerencia a persistência atômica e desduplicação de registros.
    * `MenuServico.java`: Orquestra a interface de linha de comando e validação de entradas.
    * `ConsumoApi.java` e `ConverteDados.java`: Gerenciam a comunicação externa e processamento JSON.

## Como Configurar e Rodar

1. **Banco de Dados**: Certifique-se de ter um banco de dados PostgreSQL criado.
2. **Propriedades**: No arquivo `src/main/resources/application.properties`, configure as credenciais:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
```
##Demonstração de Uso
```text
--- MENU LITERALURA ---
1- Buscar livro | 2- Listar livros | 3- Listar autores
4- Autores vivos no ano | 5- Livros por idioma | 6- Contagem por idioma
0- Sair

Sua opção: 1
Digite o título: Dom Casmurro

Registrado: Livro [Título: Dom Casmurro | Autor: Machado de Assis | Idioma: pt | Downloads: 12500]
```
## Autor

Desenvolvido por Raphael (raphaelbr22) como conclusão do desafio Literalura na trilha Java do programa Oracle Next Education.