package util;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.util.List;
public class ExibirFinanciamento {
    public static void exibirFinanciamentos(List<Financiamento> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum financiamento registrado.");
            return;
        }

        System.out.println("\nLista de Financiamentos:");
        int contador = 1;
        for (Financiamento f : lista) {
            System.out.printf("\nFinanciamento %d:\n", contador++);
            System.out.printf("Tipo: %s\n", f.getClass().getSimpleName());
            System.out.printf("Valor do imóvel: R$ %.2f\n", f.getValorImovel());
            System.out.printf("Prazo: %d anos\n", f.getPrazoFinanciamento());
            System.out.printf("Juros: %.2f%% ao ano\n", f.getTaxaJurosAnual());
            System.out.printf("Parcela mensal: R$ %.2f\n", f.calcularPagamentoMensal());
            System.out.printf("Total do financiamento: R$ %.2f\n", f.calcularTotalPagamento());
            switch (f) {
                case Casa casa -> {
                    System.out.printf("Área construída: %.2f m²\n", casa.getAreaConstruida());
                    System.out.printf("Área do terreno: %.2f m²\n", casa.getAreaTerreno());
                }
                case Apartamento ap -> {
                    System.out.printf("Andar: %d\n", ap.getNumAndar());
                    System.out.printf("Vagas de garagem: %d\n", ap.getVagasGaragem());
                }
                case Terreno terreno -> System.out.printf("Zona: %s\n", terreno.getZonaTerreno());
                default -> {
                }
            }
        }
    }
}