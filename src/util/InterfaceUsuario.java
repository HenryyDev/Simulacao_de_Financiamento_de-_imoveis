package util;

import  java.util.Scanner;
public abstract class InterfaceUsuario {
    Scanner scan = new Scanner(System.in);

    private double lerDoublePositivo(String mensagem, double min, double max) {
        double valor = -1;
        while (valor < min || valor > max) {
            System.out.println(mensagem);
            if (scan.hasNextDouble()) {
                valor = scan.nextDouble();
                if (valor < min || valor > max) {
                    System.out.printf("Valor inválido. Deve estar entre %.2f e %.2f.%n", min, max);
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scan.next();
            }
        }
        return valor;
    }
    private int lerIntEntre(String mensagem, int min, int max) {
        int valor = -1;
        while (valor < min || valor > max) {
            System.out.println(mensagem);
            if (scan.hasNextInt()) {
                valor = scan.nextInt();
                if (valor < min || valor > max) {
                    System.out.printf("Valor inválido. Deve estar entre %d e %d.%n", min, max);
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scan.next();
            }
        }
        return valor;
    }


    public double valorImovel() {
        return lerDoublePositivo("Digite o valor do imóvel (10.000 a 10.000.000): ", 10_000, 10_000_000);
    }


    public int prazoFinanciamento() {
        return lerIntEntre("Digite o prazo do financiamento em anos (5 a 35): ", 5, 35);
    }


    public double taxaJurosAnual() {
        double taxaJuros = -1;
        while (taxaJuros <= 0  || taxaJuros>30) {
            System.out.println("Digite a taxa de juros anual (ex: 1 para 1%): ");
            if (scan.hasNextDouble()) {
                taxaJuros = scan.nextDouble();
                if (taxaJuros <= 0 || taxaJuros>30) {
                    System.out.println("A taxa de juros deve ser maior que 0% e não pode ser maior que 30%, tente novamente");
                }
            } else {
                System.out.println("Entrada inválida! digite uma taxa de juros válida!");
                scan.next();
            }
        }
        return taxaJuros;
    }
    public double areaConstruida() { throw new UnsupportedOperationException(); }
    public double areaTerreno() { throw new UnsupportedOperationException(); }
    public int numeroAndar() { throw new UnsupportedOperationException(); }
    public int numeroVagas() { throw new UnsupportedOperationException(); }
    public String zonaTerreno() { throw new UnsupportedOperationException(); }
}