package com.alura.formacaoONE.literalura.repository;

import com.alura.formacaoONE.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);

    // Derived Queries otimizadas para o Card 11
    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(Integer anoInicio, Integer anoFim);

    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoIsNull(Integer ano);
}