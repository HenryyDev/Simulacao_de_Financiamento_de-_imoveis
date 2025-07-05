package util;

import exceptions.EntradaInvalidaException;
import exceptions.ValorForaDoIntervaloException;

import  java.util.Scanner;
public abstract class InterfaceUsuario {
    Scanner scan = new Scanner(System.in);

    private double lerDoublePositivo(String mensagem, double min, double max) {
        double valor = -1;
        boolean valido=false;
        while (!valido) {
            try {
                System.out.println(mensagem);
                if(!scan.hasNextDouble()){
                    scan.next();
                    throw new EntradaInvalidaException("Entrada inválida! Digite um número válido.");
                }
                valor=scan.nextDouble();
                if (valor < min || valor > max) { throw new ValorForaDoIntervaloException(String.format( "Valor inválido. Deve estar entre %.2f e %.2f.%n", min, max));
                }
                valido=true;
            }catch (EntradaInvalidaException | ValorForaDoIntervaloException e){
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }
    private int lerIntEntre(String mensagem, int min, int max) {
        int valor = -1;
        boolean valido=false;
        while (!valido) {
            try {
                System.out.println(mensagem);
                if(!scan.hasNextInt()) {
                    throw new EntradaInvalidaException("Entrada inválida! Digite um número válido.");
                }
                valor=scan.nextInt();
                if (valor < min || valor > max) {
                    throw new ValorForaDoIntervaloException(String.format("Valor inválido. Deve estar entre %d e %d.%n", min, max));
                }
                valido=true;
                } catch ( EntradaInvalidaException | ValorForaDoIntervaloException e){
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }


    public double valorImovel() {
        return lerDoublePositivo("Digite o valor do imóvel (5000 a 10.000.000): ", 5000, 10000000);
    }


    public int prazoFinanciamento() {
        return lerIntEntre("Digite o prazo do financiamento em anos (5 a 35): ", 5, 35);
    }


    public double taxaJurosAnual() {
        double taxaJuros = -1;
        boolean valido=false;
        while (!valido) {
            try {
                System.out.println("Digite a taxa de juros anual (ex: 1 para 1%): ");
                if (!scan.hasNextDouble()) {
                    scan.next();
                    throw new EntradaInvalidaException("Entrada inválida! Digite um número válido");
                }
                taxaJuros = scan.nextDouble();
                if (taxaJuros <= 0 || taxaJuros > 12) {
                    throw new ValorForaDoIntervaloException("A taxa de juros deve ser maior que 0% e não pode ser maior que 12% devido a lei de Usura, tente novamente");
                }
                valido = true;
            }catch (EntradaInvalidaException | ValorForaDoIntervaloException e) {
                System.out.println(e.getMessage());
            }
        }
        return taxaJuros;
    }

    public double areaConstruida() { throw new UnsupportedOperationException(); }//Lança exception se for chamado sem ser implementado pela subclasse
    public double areaTerreno() { throw new UnsupportedOperationException(); }
    public int numeroAndar() { throw new UnsupportedOperationException(); }
    public int numeroVagas() { throw new UnsupportedOperationException(); }
    public String zonaTerreno() { throw new UnsupportedOperationException(); }
}