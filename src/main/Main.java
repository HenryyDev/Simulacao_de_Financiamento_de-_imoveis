package main;
import modelo.Financiamento;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        //puxa dados que o usuario digitar
        InterfaceUsuario interfaceUsuario=new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();
        double somaValorImoveis = 0.0;
        double somaTotalFinanciamentos = 0.0;
        for(int i=0;i<4;i++){
            System.out.printf("Imóvel %d:\n", i + 1);
        double valorImovel= interfaceUsuario.valorImovel();
        int prazoFinanciamento=interfaceUsuario.prazoFinanciamento();
        double taxaJurosAnual=interfaceUsuario.taxaJurosAnual();
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        listaDeFinanciamentos.add(financiamento);
        double parcela=financiamento.calcularPagamentoMensal();
        double total=financiamento.calcularTotalPagamento();
        somaValorImoveis += valorImovel;
        somaTotalFinanciamentos += total;
        System.out.printf("Parcela mensal aproximada: R$ %.2f\n", parcela);
        System.out.printf("Total a pagar ao final do financiamento: R$ %.2f\n", total);
        }
        System.out.printf("Total de todos os imóveis: R$ %.2f\n", somaValorImoveis);
        System.out.printf("total de todos os financiamentos: R$ %.2f\n", somaTotalFinanciamentos);
    }
}