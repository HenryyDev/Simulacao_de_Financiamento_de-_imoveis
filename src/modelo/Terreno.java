package modelo;

public class Terreno extends Financiamento {
    private String zonaTerreno;
    public Terreno(double valorFinanciamento, int prazoFinanciamento,double taxaJurosAnual,String zonaTerreno){
        super(valorFinanciamento,prazoFinanciamento,taxaJurosAnual);
        this.zonaTerreno=zonaTerreno;
    }
    @Override
    public double calcularPagamentoMensal(){
        double parcelaBase=super.calcularPagamentoMensal();
        double taxa=1.02;
        return parcelaBase*taxa;
    }

    @Override
    public double calcularTotalPagamento() {
        double parcela=calcularPagamentoMensal();
        int prazoFinanciamento=getPrazoFinanciamento();
        return  parcela*prazoFinanciamento*12;
    }
}
