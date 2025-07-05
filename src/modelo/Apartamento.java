package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int vagasGaragem;
    protected int numAndar;
    public Apartamento(double valorFinanciamento,int prazoFinanciamento,double taxaJurosAnual,int vagasGaragem,int numAndar){
        super(valorFinanciamento,prazoFinanciamento,taxaJurosAnual);
        this.vagasGaragem=vagasGaragem;
        this.numAndar=numAndar;
    }

    public int getNumAndar() {
        return numAndar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public double getTaxaMensal() {
        return (getTaxaJurosAnual() /100)/ 12;
    }
    public int getMeses(){
        return super.getPrazoFinanciamento()*12;
    }
    public double calcularPagamentoMensal(){
        double taxa = getTaxaMensal();
        double valorImovel = getValorImovel();
        int meses = getMeses();
        double termoPotencia = Math.pow(1 + taxa, meses);
        double numerador = valorImovel * taxa * termoPotencia;
        double denominador = termoPotencia - 1;
        return numerador / denominador;
    }
    public double calcularTotalPagamento() {
        double parcela=calcularPagamentoMensal();
        int prazoFinanciamento=getPrazoFinanciamento();
        return  parcela*prazoFinanciamento*12;
    }
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Apartamento");
        string.append(";valor=").append(getValorImovel());
        string.append(";prazo=").append(getPrazoFinanciamento());
        string.append(";juros=").append(getTaxaJurosAnual());
        string.append(";andar=").append(numAndar);
        string.append(";vagas=").append(vagasGaragem);
        string.append(";total=").append(String.format("%.2f", calcularTotalPagamento()));
        return string.toString();
    }
}
