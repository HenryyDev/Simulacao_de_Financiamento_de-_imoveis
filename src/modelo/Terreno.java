package modelo;

public class Terreno extends Financiamento {
    public Terreno(double valorFinanciamento, int prazoFinanciamento,double taxaJurosAnual){
        super(valorFinanciamento,prazoFinanciamento,taxaJurosAnual);
    }
    @Override
    public double calcularPagamentoMensal(){
        double parcelaBase=super.calcularPagamentoMensal();
        double taxa=1.02;
        return parcelaBase*taxa;
    }
}
