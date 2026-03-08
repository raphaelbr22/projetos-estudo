package com.alura.formacaoONE.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    // Instanciamos o ObjectMapper, que é a ferramenta do Jackson que faz o mapeamento
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // Tenta ler o JSON e transformá-lo na classe especificada
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            // Caso o JSON venha quebrado ou com formato inesperado
            throw new RuntimeException("Erro na conversão do JSON: " + e.getMessage());
        }
    }
}