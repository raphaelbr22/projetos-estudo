package com.alura.formacaoONE.literalura.main;

import com.alura.formacaoONE.literalura.model.Autor;
import com.alura.formacaoONE.literalura.model.DadosResposta;
import com.alura.formacaoONE.literalura.model.Livro;
import com.alura.formacaoONE.literalura.repository.IAutorRepository;
import com.alura.formacaoONE.literalura.repository.ILivroRepository;
import com.alura.formacaoONE.literalura.service.ConsumoApi;
import com.alura.formacaoONE.literalura.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    // Variáveis para receber os repositórios
    private ILivroRepository repositorio;
    private IAutorRepository autorRepositorio;

    // Construtor atualizado recebendo os dois repositórios
    public Principal(ILivroRepository repositorio, IAutorRepository autorRepositorio) {
        this.repositorio = repositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    
                    *** Bem-vindo ao LiterAlura! ***
                    
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar livros por idioma
                    0 - Sair
                    
                    Escolha uma opção válida:
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine(); // Consome o Enter

            switch (opcao) {
                case 1:
                    buscarLivroWeb();
                    break;
                case 2:
                    listarLivrosBuscados();
                    break;
                case 3:
                    listarLivrosPorIdioma();
                    break;    
                case 0:
                    System.out.println("Encerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Insira o idioma para realizar a busca:");
        System.out.println("es - espanhol");
        System.out.println("en - inglês");
        System.out.println("fr - francês");
        System.out.println("pt - português");

        var idioma = leitura.nextLine();

        List<Livro> livrosPorIdioma = repositorio.findByIdioma(idioma);

        if (livrosPorIdioma.isEmpty()) {
            System.out.println("Não existem livros nesse idioma no banco de dados.");
        } else {
            livrosPorIdioma.forEach(System.out::println);
        }
    }

    private void buscarLivroWeb() {
        System.out.println("Digite o nome do livro que você deseja buscar:");
        var tituloLivro = leitura.nextLine();

        var json = consumo.obterDados(ENDERECO + tituloLivro.replace(" ", "%20"));
        DadosResposta dados = conversor.obterDados(json, DadosResposta.class);

        if (dados.resultados() != null && !dados.resultados().isEmpty()) {
            var dadosLivro = dados.resultados().get(0);
            Livro livro = new Livro(dadosLivro);

            if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
                var dadosAutor = dadosLivro.autores().get(0);

                // Verifica se o autor já existe no banco. Se não existir, cria um novo!
                Autor autor = autorRepositorio.findByNome(dadosAutor.nome())
                        .orElseGet(() -> new Autor(dadosAutor));

                livro.setAutor(autor);
            }

            repositorio.save(livro);

            System.out.println("\nLivro salvo no banco de dados com sucesso!");
            System.out.println(livro.toString());
        } else {
            System.out.println("\nLivro não encontrado na base da Gutendex.");
        }
    }

    private void listarLivrosBuscados() {
        System.out.println("\n--- Livros Registrados na Base de Dados ---");
        List<Livro> livros = repositorio.findAll();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro foi registado ainda.");
        } else {
            livros.forEach(System.out::println);
        }
    }
}