package model;

import java.util.Map;

// O record define imutabilidade e clareza para os dados da API
public record MoedaDTO(String result,
                       String base_code,
                       Map<String, Double> conversion_rates) {
}