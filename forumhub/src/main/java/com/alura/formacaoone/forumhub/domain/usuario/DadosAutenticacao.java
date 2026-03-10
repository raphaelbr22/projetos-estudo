package com.alura.formacaoone.forumhub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

// domain/usuario/DadosAutenticacao.java
public record DadosAutenticacao(
        @NotBlank String login,
        @NotBlank String senha
) {}