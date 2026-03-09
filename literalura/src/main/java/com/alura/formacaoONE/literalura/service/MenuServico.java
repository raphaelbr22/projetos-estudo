package com.alura.formacaoONE.literalura.service;

import com.alura.formacaoONE.literalura.model.Autor;
import com.alura.formacaoONE.literalura.model.DadosResposta;
import com.alura.formacaoONE.literalura.model.Livro;
import com.alura.formacaoONE.literalura.repository.IAutorRepository;
import com.alura.formacaoONE.literalura.repository.ILivroRepository;

import java.util.List;
import java.util.Scanner;

public class MenuServico {
    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoApi consumo = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private final ILivroRepository livroRepo;
    private final IAutorRepository autorRepo;
    private final LivroService livroService;

    public MenuServico(ILivroRepository livroRepo, IAutorRepository autorRepo, LivroService livroService) {
        this.livroRepo = livroRepo;
        this.autorRepo = autorRepo;
        this.livroService = livroService;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            imprimirMenu();
            try {
                opcao = Integer.parseInt(leitura.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um valor numérico válido.");
            }
        }
    }

    private void imprimirMenu() {
        System.out.println("""
                \n--- LITERALURA ---
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros por idioma
                6 - Estatísticas por idioma
                0 - Sair
                """);
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> buscarNovoLivro();
            case 2 -> listarTodosLivros();
            case 3 -> listarTodosAutores();
            case 4 -> buscarAutoresVivos();
            case 5 -> buscarPorIdioma();
            case 6 -> gerarEstatisticasIdioma();
            case 0 -> System.out.println("Finalizando aplicação...");
            default -> System.out.println("Opção inválida.");
        }
    }

    private void buscarNovoLivro() {
        System.out.println("Digite o título:");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(URL_BASE + nomeLivro.replace(" ", "%20"));
        DadosResposta dados = conversor.obterDados(json, DadosResposta.class);

        if (dados.resultados() != null && !dados.resultados().isEmpty()) {
            Livro livroSalvo = livroService.salvarLivroComAutor(dados.resultados().get(0));
            System.out.println("Sucesso: " + livroSalvo);
        } else {
            System.out.println("Livro não localizado na API.");
        }
    }

    private void listarTodosLivros() {
        livroRepo.findAll().forEach(System.out::println);
    }

    private void listarTodosAutores() {
        autorRepo.findAll().forEach(System.out::println);
    }

    private void buscarAutoresVivos() {
        System.out.println("Ano de referência:");
        try {
            int ano = Integer.parseInt(leitura.nextLine());
            List<Autor> autores = autorRepo.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(ano, ano);
            autores.addAll(autorRepo.findByAnoNascimentoLessThanEqualAndAnoFalecimentoIsNull(ano));

            if (autores.isEmpty()) {
                System.out.println("Nenhum autor vivo encontrado para o ano " + ano);
            } else {
                autores.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ano inválido.");
        }
    }

    private void buscarPorIdioma() {
        System.out.println("Idioma (pt, en, es, fr):");
        var idioma = leitura.nextLine();
        livroRepo.findByIdioma(idioma).forEach(System.out::println);
    }

    private void gerarEstatisticasIdioma() {
        System.out.println("Idioma para contagem:");
        var idioma = leitura.nextLine();
        System.out.println("Total registrado: " + livroRepo.countByIdioma(idioma));
    }
}