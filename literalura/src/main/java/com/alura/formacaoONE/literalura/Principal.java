package com.alura.formacaoONE.literalura;

import com.alura.formacaoONE.literalura.service.MenuServico;
import com.alura.formacaoONE.literalura.repository.IAutorRepository;
import com.alura.formacaoONE.literalura.repository.ILivroRepository;
import com.alura.formacaoONE.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal implements CommandLineRunner {

    @Autowired private ILivroRepository livroRepo;
    @Autowired private IAutorRepository autorRepo;
    @Autowired private LivroService livroService;

    public static void main(String[] args) {
        SpringApplication.run(Principal.class, args);
    }

    @Override
    public void run(String... args) {
        MenuServico principal = new MenuServico(livroRepo, autorRepo, livroService);
        principal.exibeMenu();
    }
}