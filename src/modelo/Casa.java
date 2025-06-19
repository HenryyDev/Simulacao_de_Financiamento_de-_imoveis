package modelo;

public class Casa extends Financiamento{
    final private double valorSeguro=80;
    public Casa(double valorFinanciamento, int prazoFinanciamento,double taxaJurosAnual){
        super(valorFinanciamento,prazoFinanciamento,taxaJurosAnual);
    }
    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal()+valorSeguro;
    }
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal()*getPrazoFinanciamento()*12;
    }

}
