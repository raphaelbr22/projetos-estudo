package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final String[] moedas = {"USD", "BRL", "EUR", "GBP"};

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirBoasVindas() {
        System.out.println("=== BEM-VINDO AO CONVERSOR DE MOEDAS ===");
    }

    public String escolherMoeda(String tipo) {
        while (true) {
            try {
                System.out.println("\n--- SELECIONE A MOEDA DE " + tipo + " ---");
                for (int i = 0; i < moedas.length; i++) {
                    System.out.println((i + 1) + ") " + moedas[i]);
                }
                System.out.println("0) Sair");
                System.out.print("Sua opção: ");

                int opcao = scanner.nextInt();

                if (opcao == 0) return "SAIR";
                if (opcao >= 1 && opcao <= moedas.length) {
                    return moedas[opcao - 1];
                }

                System.err.println("Erro: Opção inválida. Tente de 1 a " + moedas.length);
            } catch (InputMismatchException e) {
                System.err.println("Erro: Digite apenas números inteiros.");
                scanner.nextLine(); // Limpa buffer
            }
        }
    }

    public double lerValor() {
        while (true) {
            try {
                System.out.print("Digite o valor para conversão: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.err.println("Erro: Digite um valor numérico válido (ex: 100,50).");
                scanner.nextLine(); // Limpa buffer
            }
        }
    }

    public void exibirResultado(String de, String para, double valor, double taxa) {
        System.out.println("\n" + "=".repeat(40));
        System.out.printf(">>> %.2f %s = %.2f %s%n", valor, de, (valor * taxa), para);
        System.out.printf("(Taxa de câmbio: %.4f)%n", taxa);
        System.out.println("=".repeat(40));
    }

    public void finalizar() {
        System.out.println("Obrigado por usar o conversor! Até logo.");
        scanner.close();
    }
}