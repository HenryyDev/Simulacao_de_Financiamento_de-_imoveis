package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    protected  String zonaTerreno;

    public Terreno(double valorFinanciamento, int prazoFinanciamento, double taxaJurosAnual, String zonaTerreno) {
        super(valorFinanciamento, prazoFinanciamento, taxaJurosAnual);
        this.zonaTerreno = zonaTerreno;
    }

    public String getZonaTerreno() {
        return zonaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double parcelaBase = super.calcularPagamentoMensal();
        double taxa = 1.02;
        return parcelaBase * taxa;
    }

    @Override
    public double calcularTotalPagamento() {
        double parcela = calcularPagamentoMensal();
        int prazoFinanciamento = getPrazoFinanciamento();
        return parcela * prazoFinanciamento * 12;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Terreno");
        string.append(";valor=").append(getValorImovel());
        string.append(";prazo=").append(getPrazoFinanciamento());
        string.append(";juros=").append(getTaxaJurosAnual());
        string.append(";zona=").append(zonaTerreno);
        string.append(";total=").append(String.format("%.2f", calcularTotalPagamento()));
        return string.toString();

    }
}
