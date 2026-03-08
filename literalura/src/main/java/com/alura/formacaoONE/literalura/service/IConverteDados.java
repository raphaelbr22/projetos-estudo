package com.alura.formacaoONE.literalura.service;

public interface IConverteDados {
    // Usamos Generics (<T>) para que o método possa retornar qualquer tipo de classe que passarmos para ele
    <T> T obterDados(String json, Class<T> classe);
}