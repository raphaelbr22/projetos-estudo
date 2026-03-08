package com.alura.formacaoONE.literalura.repository;

import com.alura.formacaoONE.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ILivroRepository extends JpaRepository<Livro, Long> {
    // Nova busca personalizada por idioma
    List<Livro> findByIdioma(String idioma);
}