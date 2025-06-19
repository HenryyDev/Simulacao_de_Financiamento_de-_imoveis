package modelo;

public class Apartamento extends Financiamento{

    public Apartamento(double valorFinanciamento,int prazoFinanciamento,int taxaJurosAnual){
        super(valorFinanciamento,prazoFinanciamento,taxaJurosAnual);
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
}
