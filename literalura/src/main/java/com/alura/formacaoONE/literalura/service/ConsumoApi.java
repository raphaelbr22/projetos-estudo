package com.alura.formacaoONE.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        // No Java 17, usamos 'var' para reduzir a verbosidade sem perder a tipagem forte
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            // Faz a requisição e recebe a resposta como String (JSON)
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            // Tratamento de erro conforme sugerido no Card 3
            throw new RuntimeException("Erro ao buscar dados da API Gutendex: " + e.getMessage());
        }
    }
}