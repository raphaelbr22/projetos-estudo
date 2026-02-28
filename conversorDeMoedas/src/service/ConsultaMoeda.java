package service;

import com.google.gson.Gson;
import model.MoedaDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoeda {

    public MoedaDTO buscaTaxas(String moedaBase) {
        // Use sua chave real aqui
        String apiKey = "2018dfd38944aaf293b355dc";
        String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), MoedaDTO.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao conectar com a API: " + e.getMessage());
        }
    }
}