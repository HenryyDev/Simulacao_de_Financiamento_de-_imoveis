package modelo;
import exceptions.AumentoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    protected double valorSeguro = 80;
    protected Double parcelaMensal = null;
    protected double areaConstruida;



    protected double areaTerreno;

    public Casa(double valorFinanciamento, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorFinanciamento, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }
    public double calcularPagamentoMensal() {
        if (parcelaMensal != null) {
            return parcelaMensal; // já calculou uma vez, retorna para n ficar repetindo no console
        }
        double metadeJuros = calcularMetadeJurosMensal();
        try {
            if (valorSeguro > metadeJuros) {
                throw new AumentoMaiorDoQueJurosException("O valor do seguro é maior que a metade dos juros mensais!");
            }
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("Aviso: " + e.getMessage());
            valorSeguro = metadeJuros; // Ajusta o valor do seguro para metade dos juros
            System.out.printf("\nValor do seguro Mensal ajustado para metade dos juros mensais: R$ %.2f", valorSeguro);
        }
        parcelaMensal = calcularPagamentoSemSeguro() + valorSeguro;
        return parcelaMensal;
    }

    private double calcularPagamentoSemSeguro() {
        return super.calcularPagamentoMensal();
    }

    public double calcularMetadeJurosMensal() {
        double mensalSemSeguro = super.calcularPagamentoMensal();
        double jurosMensal = mensalSemSeguro * (getTaxaJurosAnual() / 12);
        return jurosMensal / 2;
    }

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Casa");
        string.append(";valor=").append(getValorImovel());
        string.append(";prazo=").append(getPrazoFinanciamento());
        string.append(";juros=").append(getTaxaJurosAnual());
        string.append(";area=").append(areaConstruida);
        string.append(";terreno=").append(areaTerreno);
        string.append(";total=").append(String.format("%.2f", calcularTotalPagamento()));
        return string.toString();
    }
}
