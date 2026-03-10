package com.alura.formacaoone.forumhub.controller;

import com.alura.formacaoone.forumhub.domain.usuario.DadosAutenticacao;
import com.alura.formacaoone.forumhub.domain.usuario.DadosTokenJWT;
import com.alura.formacaoone.forumhub.domain.usuario.Usuario;
import com.alura.formacaoone.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        // Cria o DTO interno que o Spring Security espera para processar a autenticação
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        // Chama o AuthenticationManager para validar se login e senha batem com o banco
        var authentication = manager.authenticate(authenticationToken);

        // Se a validação passar, gera o Token JWT para o usuário autenticado
        var tokenJWT = tokenService.gerarToken((Usuario) Objects.requireNonNull(authentication.getPrincipal()));

        // Retorna o Token no corpo da resposta dentro do DTO que criamos
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}