package main;

import model.MoedaDTO;
import service.ConsultaMoeda;

public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ConsultaMoeda consulta = new ConsultaMoeda();

        menu.exibirBoasVindas();

        while (true) {
            // 1. Moeda de Origem
            String origem = menu.escolherMoeda("ORIGEM");
            if (origem.equals("SAIR")) break;

            // 2. Moeda de Destino
            String destino = menu.escolherMoeda("DESTINO");
            if (destino.equals("SAIR")) break;

            // 3. Valor
            double valor = menu.lerValor();

            // 4. Lógica de Negócio
            try {
                MoedaDTO dados = consulta.buscaTaxas(origem);
                Double taxa = dados.conversion_rates().get(destino);

                if (taxa != null) {
                    menu.exibirResultado(origem, destino, valor, taxa);
                }
            } catch (Exception e) {
                System.err.println("Erro na operação: " + e.getMessage());
            }
        }

        menu.finalizar();
    }
}