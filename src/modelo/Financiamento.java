package modelo;

import exceptions.AumentoMaiorDoQueJurosException;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    protected double valorFinanciamento;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }



    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }



    public double getValorImovel() {
        return valorFinanciamento;
    }

    //construtor
    public Financiamento(double valorFinanciamento, int prazoFinanciamento, double taxaJurosAnual){
        this.valorFinanciamento=valorFinanciamento;
        this.prazoFinanciamento=prazoFinanciamento;
        this.taxaJurosAnual=taxaJurosAnual;
    }
    public double calcularPagamentoMensal()  throws AumentoMaiorDoQueJurosException {
        int prazoEmMeses = this.prazoFinanciamento * 12;
        double taxaMensal = (this.taxaJurosAnual/100.0) / 12;

        return (this.valorFinanciamento/ prazoEmMeses) * (1 + taxaMensal);
    }

    public abstract double calcularTotalPagamento();
}
