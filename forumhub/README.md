# Challenge ForumHub - Oracle Next Education

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%234479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

Este projeto é um desafio prático proposto pelo programa ONE (Oracle Next Education) em parceria com a Alura. O objetivo é aplicar conhecimentos avançados de Java (JDK 17), Spring Boot, segurança com Spring Security e persistência de dados em bancos relacionais na construção de uma API REST para um fórum de discussões.

## O Desafio

Desenvolver uma API completa para gerenciamento de tópicos de um fórum, seguindo o modelo CRUD (Create, Read, Update, Delete) e protegendo os endpoints com autenticação via Tokens JWT. A aplicação deve persistir dados em um banco de dados relacional e seguir as melhores práticas de arquitetura REST, garantindo que apenas usuários autenticados possam interagir com os recursos protegidos.

## Funcionalidades Implementadas

* **Autenticação e Segurança:** Login de usuários com geração de tokens JWT para proteção de rotas.
* **Gestão de Tópicos:** Criação, listagem, atualização e exclusão de discussões no banco de dados.
* **Paginação e Ordenação:** Listagem eficiente de registros para otimização de performance e facilidade de navegação.
* **Detalhamento de Recursos:** Consulta individual de tópicos por identificador único (ID) retornando dados específicos.
* **Validação de Dados:** Garantia de integridade das informações enviadas via Bean Validation para evitar campos nulos ou inválidos.
* **Documentação Interativa:** Interface visual para testes da API via SpringDoc OpenAPI (Swagger).

## Tecnologias Utilizadas

* **Java 17 (LTS):** Utilização de Records, Streams e tratamento de exceções robusto.
* **Spring Boot 3:** Framework para gestão de dependências e inversão de controle.
* **Spring Data JPA:** Abstração da camada de persistência para interação com o banco de dados.
* **Spring Security:** Implementação de filtros de autenticacao e autorização stateless para API REST.
* **Auth0 JWT:** Biblioteca utilizada para a geração, assinatura e validação de tokens JSON Web Tokens.
* **MySQL:** Banco de dados relacional utilizado para o armazenamento persistente dos dados.
* **Flyway:** Ferramenta de versionamento e migração de esquemas de banco de dados.
* **IntelliJ IDEA:** IDE utilizada para o desenvolvimento e gestão do projeto via Maven.

## Estrutura do Projeto

A organização segue os princípios de Clean Code e separação de responsabilidades em camadas:
* **br.com.alura.forumhub:** Contém a classe principal e ponto de entrada do sistema.
* **br.com.alura.forumhub.controller:** Exposição dos endpoints REST para autenticação e gerenciamento de tópicos.
* **br.com.alura.forumhub.domain:** Contém as entidades JPA (Tópico, Usuário) e os Records utilizados como DTOs.
* **br.com.alura.forumhub.infra:** Configurações de segurança, filtros JWT e tratador de erros centralizado.
* **br.com.alura.forumhub.repository:** Interfaces para operações de CRUD e consultas personalizadas ao banco de dados.

## Como Configurar e Rodar

1. **Banco de Dados:** Certifique-se de ter um banco de dados MySQL criado (ex: `forum_api`).
2. **Propriedades:** No arquivo `src/main/resources/application.properties`, configure as credenciais:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forum_api
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   api.security.token.secret=sua_chave_secreta_jwt
   ```
   
Execução: Execute o projeto via Maven ou sua IDE de preferência. O Flyway executará as migrations automaticamente para criar as tabelas.

## Demonstração de Uso (Endpoints)

```text
POST /login -> Recebe credenciais de usuário e retorna o Token JWT.

POST /topicos -> Cadastra novo tópico (Requer Header Authorization: Bearer <token>).

GET /topicos -> Lista todos os tópicos paginados.

GET /topicos/{id} -> Detalha um tópico específico por ID.

PUT /topicos/{id} -> Atualiza título ou mensagem de um tópico existente.

DELETE /topicos/{id} -> Remove um tópico permanentemente.
```

Documentação completa disponível em: http://localhost:8080/swagger-ui.html

## Autor

Desenvolvido por Raphael (raphaelbr22) como conclusão do desafio ForumHub na trilha Java do programa Oracle Next Education.