package main;
import modelo.*;
import util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InterfaceUsuario interfaceUsuario = null;
        boolean continuar = true;
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        double somaValorImoveis = 0.0;
        double somaTotalFinanciamentos = 0.0;
        while (continuar) {
            System.out.println("Escolha o tipo de imóvel:");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");
            System.out.println("4 - Sair");
            int opcao = -1;
            while (opcao < 1 || opcao > 4) {
                System.out.print("Digite a opção desejada (1 a 4): ");
                if (scan.hasNextInt()) {
                    opcao = scan.nextInt();
                } else {
                    System.out.println("Entrada inválida!");
                    scan.next();
                }
            }
            if (opcao == 4) {
                System.out.println("Encerrando o programa. Até logo!");
                continuar = false;
                break;
            }
            switch (opcao) {
                case 1:
                    interfaceUsuario = new InterfaceCasa();
                    break;
                case 2:
                    interfaceUsuario = new InterfaceApartamento();
                    break;
                case 3:
                    interfaceUsuario = new InterfaceTerreno();
                    break;
            }
            // entrada comum
            double valor = interfaceUsuario.valorImovel();
            int prazo = interfaceUsuario.prazoFinanciamento();
            double juros = interfaceUsuario.taxaJurosAnual();

            switch (opcao) {
                case 1:
                    double area = interfaceUsuario.areaConstruida();
                    double terreno = interfaceUsuario.areaTerreno();
                    listaDeFinanciamentos.add(new Casa(valor, prazo, juros, area, terreno));
                    break;

                case 2:
                    int andar = interfaceUsuario.numeroAndar();
                    int vagas=interfaceUsuario.numeroVagas();
                    listaDeFinanciamentos.add(new Apartamento(valor, prazo, juros, andar, vagas));
                    break;

                case 3:
                    String zona = interfaceUsuario.zonaTerreno(); // implementar
                    listaDeFinanciamentos.add(new Terreno(valor, prazo, juros, zona));
                    break;
            }

            // 2 apartamentos
            //listaDeFinanciamentos.add(new Apartamento(500000, 10, 10,1,10));

            // 1 terreno
            //listaDeFinanciamentos.add(new Terreno(500000, 10, 10,"Comercial"));

            // Exibir e somar os dados de todos os financiamentos
            for (int i = 0; i < listaDeFinanciamentos.size(); i++) {
                Financiamento f = listaDeFinanciamentos.get(i);
                double parcela = f.calcularPagamentoMensal();
                double total = f.calcularTotalPagamento();

                System.out.printf("\nFinanciamento %d:\n", i + 1);
                System.out.printf("Valor do imóvel: R$ %.2f\n", f.getValorImovel());
                System.out.printf("Parcela mensal: R$ %.2f\n", parcela);
                System.out.printf("Total a pagar: R$ %.2f\n", total);

                somaValorImoveis += f.getValorImovel();
                somaTotalFinanciamentos += total;
            }
        }
            // Totais
            System.out.printf("\nTotal dos valores dos imóveis: R$ %.2f\n", somaValorImoveis);
            System.out.printf("Total dos valores dos financiamentos: R$ %.2f\n", somaTotalFinanciamentos);

    }
}
