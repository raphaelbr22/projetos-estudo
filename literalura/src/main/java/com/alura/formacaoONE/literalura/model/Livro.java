package com.alura.formacaoONE.literalura.model;

import jakarta.persistence.Column;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    // Vamos guardar apenas uma string com o primeiro idioma da lista
    private String idioma;

    private Integer numeroDownloads;

    // Relacionamento: Vários livros podem pertencer a um autor
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        // Pegamos apenas o primeiro idioma da lista (se existir)
        if (dadosLivro.idiomas() != null && !dadosLivro.idiomas().isEmpty()) {
            this.idioma = dadosLivro.idiomas().get(0);
        }
        this.numeroDownloads = dadosLivro.numeroDownloads();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public Integer getNumeroDownloads() { return numeroDownloads; }
    public void setNumeroDownloads(Integer numeroDownloads) { this.numeroDownloads = numeroDownloads; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Título: " + titulo +
                " | Autor: " + (autor != null ? autor.getNome() : "Desconhecido") +
                " | Idioma: " + idioma +
                " | Downloads: " + numeroDownloads;
    }
}