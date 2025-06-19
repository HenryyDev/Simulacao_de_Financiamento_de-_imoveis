package main;

import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        double somaValorImoveis = 0.0;
        double somaTotalFinanciamentos = 0.0;

        // 1 financiamento com dados digitados pelo usuário
        System.out.println("Digite os dados do primeiro financiamento:");
        double valorImovel = interfaceUsuario.valorImovel();
        int prazoFinanciamento = interfaceUsuario.prazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.taxaJurosAnual();

        Financiamento financiamentoUsuario = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(financiamentoUsuario);

        // 2 apartamentos
        listaDeFinanciamentos.add(new Apartamento(500000, 10, 10));

        // 1 terreno
        listaDeFinanciamentos.add(new Terreno(500000, 10, 10));

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

        // Totais
        System.out.printf("\nTotal dos valores dos imóveis: R$ %.2f\n", somaValorImoveis);
        System.out.printf("Total dos valores dos financiamentos: R$ %.2f\n", somaTotalFinanciamentos);
    }
}
