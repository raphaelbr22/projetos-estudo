package com.alura.formacaoone.forumhub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Para a regra de negócio do Cadastro (Não permitir duplicados)
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

    // Para a Listagem (Já herdado do JpaRepository, mas você pode customizar se precisar)
    Page<Topico> findAll(Pageable paginacao);
}