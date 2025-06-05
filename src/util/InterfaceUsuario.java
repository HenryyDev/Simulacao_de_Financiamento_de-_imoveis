package util;

import  java.util.Scanner;
public class InterfaceUsuario {
    Scanner scan = new Scanner(System.in);

    public double valorImovel() {
        double valor = -1;
        while (valor <= 0 || valor < 10_000.00 || valor > 10_000_000.00) {
            System.out.println("Digite o valor do imóvel:");
            if (scan.hasNextDouble()) {
                valor = scan.nextDouble();
                if (valor < 10_000.00) {
                    System.out.println("Valor do imóvel menor que o limite minimo (R$ 10.000,00) tente novamente");
                    valor = -1;
                }
                else if (valor>10_000_000.00) {
                    System.out.println("Valor do imóvel ultrapassa o limite permitido (R$ 10.000.000,00) tente novamente.");
                    valor = -1;}
            } else {
                System.out.println("Entrada inválida! Digite um número válido");
                scan.next();
            }
        }

        return valor;
    }

    public int prazoFinanciamento() {
        int prazo = -1;
        while (prazo <= 0 || prazo <5 || prazo>35) {
            System.out.println("Digite o prazo do financiamento em anos (entre 5 e 35): ");
            if (scan.hasNextInt()) {
                prazo = scan.nextInt();
                if (prazo <5 || prazo>35) {
                    System.out.println("O prazo deve estar entre 5 e 35 anos. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! digite um prazo válido!");
                scan.next();
            }
        }

        return prazo;
    }

    public double taxaJurosAnual() {
        double taxaJuros = -1;
        while (taxaJuros <= 0 || taxaJuros <= 0 || taxaJuros>30) {
            System.out.println("Digite a taxa de juros: ");
            if (scan.hasNextDouble()) {
                taxaJuros = scan.nextDouble();
                if (taxaJuros <= 0 || taxaJuros>30) {
                    System.out.println("A taxa de juros deve ser maior que 0% e não pode ser maior que 30%, tente novamente");
                }
            } else {
                System.out.println("Entrada inválida! digite um prazo válido!");
                scan.next();
            }
        }
        return taxaJuros;
    }
}