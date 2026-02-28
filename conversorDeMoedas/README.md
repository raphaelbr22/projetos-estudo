# Challenge Conversor de Moedas - Oracle Next Education

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![Alura](https://img.shields.io/badge/Alura-17222E?style=for-the-badge&logo=alura&logoColor=white)

Este projeto é um desafio prático proposto pelo programa **ONE (Oracle Next Education)** em parceria com a **Alura**. O objetivo é aplicar os conhecimentos de Java (JDK 17), consumo de APIs e manipulação de arquivos JSON em uma aplicação real de conversão de moedas.



## O Desafio
Desenvolver um conversor de moedas que realize requisições a uma API de taxas de câmbio, processe os dados e forneça uma interface interativa via console para o usuário.

### Moedas Suportadas nesta Versão:
* **USD** (Dólar Americano)
* **BRL** (Real Brasileiro)
* **EUR** (Euro)
* **GBP** (Libra Esterlina)

## Tecnologias Utilizadas

* **Java 17 (LTS)**: Utilização de `Records`, `Text Blocks` e `HttpClient` nativo.
* **Gson 2.10.1**: Biblioteca do Google para conversão de JSON em objetos Java.
* **ExchangeRate-API**: Interface utilizada para obter as cotações em tempo real.
* **IntelliJ IDEA Ultimate**: IDE utilizada para o desenvolvimento e gestão de dependências.
* **Postman**: Utilizado para testes de endpoints e validação da estrutura JSON.

## Estrutura do Projeto

A organização segue os princípios de **Clean Code**, **Encapsulamento** e **SRP (Single Responsibility Principle)**:

* `br.com.alura.conversor.model`: Contém o Record `MoedaDTO`, responsável pelo mapeamento dos dados da API.
* `br.com.alura.conversor.service`: Contém a classe `ConsultaMoeda`, que isola a lógica de requisição HTTP e desserialização.
* `br.com.alura.conversor.main`: Contém a lógica de execução e interface:
    * `Principal.java`: Orquestra o fluxo da aplicação.
    * `Menu.java`: Gerencia a interação, validação de entrada (`InputMismatchException`) e interface visual.



## Como Configurar e Rodar

1. **Chave da API**: Obtenha sua chave gratuita em [ExchangeRate-API](https://www.exchangerate-api.com/).
2. **Dependência**: Certifique-se de que o arquivo `gson-2.10.1.jar` esteja adicionado às **Libraries** do seu projeto no IntelliJ.
3. **Variável de API**: No arquivo `ConsultaMoeda.java`, substitua o campo `apiKey` pela sua chave gerada.
4. **Execução**: Rode a classe `Principal.java` para iniciar o loop de conversão no terminal.

## Demonstração de Uso

```text
=== BEM-VINDO AO CONVERSOR DE MOEDAS ONE ===

--- SELECIONE A MOEDA DE ORIGEM ---
1) USD
2) BRL
3) EUR
4) GBP
0) Sair
Sua opção: 1

Digite o valor para conversão: 50.00

--- SELECIONE A MOEDA DE DESTINO ---
Sua opção: 2

========================================
>>> 50.00 USD = 254.25 BRL
(Taxa de câmbio aplicada: 5.0850)
========================================
```

## Autor

Desenvolvido por Raphael (raphaelbr22) como parte da trilha de Java do programa Oracle Next Education, na plataforma Alura.