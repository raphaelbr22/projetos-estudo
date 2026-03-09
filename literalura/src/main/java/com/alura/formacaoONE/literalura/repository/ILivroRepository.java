package com.alura.formacaoONE.literalura.repository;

import com.alura.formacaoONE.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ILivroRepository extends JpaRepository<Livro, Long> {
    // Recuperação de registros por critério de idioma
    List<Livro> findByIdioma(String idioma);

    // Operação de contagem para geração de estatísticas de catálogo
    Integer countByIdioma(String idioma);
}