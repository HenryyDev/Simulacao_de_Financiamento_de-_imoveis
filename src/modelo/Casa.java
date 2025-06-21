package modelo;

public class Casa extends Financiamento{
    final private double valorSeguro=80;
    private double areaConstruida;
    private double areaTerrreno;
    public Casa(double valorFinanciamento, int prazoFinanciamento,double taxaJurosAnual,double areaConstruida, double areaTerrreno){
        super(valorFinanciamento,prazoFinanciamento,taxaJurosAnual);
        this.areaConstruida=areaConstruida;
        this.areaTerrreno=areaTerrreno;
    }
    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal()+valorSeguro;
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal()*getPrazoFinanciamento()*12;
    }


}
