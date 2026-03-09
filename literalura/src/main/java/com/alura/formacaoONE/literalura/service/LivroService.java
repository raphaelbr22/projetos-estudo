package com.alura.formacaoONE.literalura.service;

import com.alura.formacaoONE.literalura.model.Autor;
import com.alura.formacaoONE.literalura.model.DadosLivro;
import com.alura.formacaoONE.literalura.model.Livro;
import com.alura.formacaoONE.literalura.repository.IAutorRepository;
import com.alura.formacaoONE.literalura.repository.ILivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LivroService {

    @Autowired
    private ILivroRepository livroRepositorio;

    @Autowired
    private IAutorRepository autorRepositorio;

    // Persistência atômica garantindo a relação ID entre Livro e Autor
    @Transactional
    public Livro salvarLivroComAutor(DadosLivro dadosLivro) {
        Livro livro = new Livro(dadosLivro);

        if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
            var dadosAutor = dadosLivro.autores().get(0);

            // Lógica de desduplicação: recupera existente ou persiste novo
            Autor autor = autorRepositorio.findByNome(dadosAutor.nome())
                    .orElseGet(() -> autorRepositorio.save(new Autor(dadosAutor)));

            livro.setAutor(autor);
        }

        return livroRepositorio.save(livro);
    }
}