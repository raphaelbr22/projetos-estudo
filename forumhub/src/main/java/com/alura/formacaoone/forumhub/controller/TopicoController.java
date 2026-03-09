package com.alura.formacaoone.forumhub.controller;

import com.alura.formacaoone.forumhub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var jaExiste = repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if (jaExiste) {
            return ResponseEntity.badRequest().body("Erro: Tópico já cadastrado com mesmo título e mensagem.");
        }

        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listar(
            @PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.ASC) Pageable paginacao) {

        var pagina = repository.findAll(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topicoOptional = repository.findById(id);
        if (topicoOptional.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topicoOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();

            // Regra de duplicidade: não pode atualizar para um título/mensagem que já existe em outro tópico
            var jaExiste = repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());
            if (jaExiste) {
                return ResponseEntity.badRequest().body("Já existe um tópico com este título e mensagem.");
            }

            topico.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna Status 204
        }

        return ResponseEntity.notFound().build(); // Retorna Status 404
    }
}