package com.alura.formacaoONE.literalura;

import com.alura.formacaoONE.literalura.main.Principal;
import com.alura.formacaoONE.literalura.repository.IAutorRepository;
import com.alura.formacaoONE.literalura.repository.ILivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private ILivroRepository repositorio;

    // Injetando o nosso novo repositório de autores
    @Autowired
    private IAutorRepository autorRepositorio;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Agora passamos os DOIS repositórios para a Principal
        Principal principal = new Principal(repositorio, autorRepositorio);
        principal.exibeMenu();
    }
}