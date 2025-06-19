package modelo;

public class Financiamento {
    private double valorFinanciamento;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorFinanciamento;
    }

    public void setValorImovel(double valorFinanciamento) {
        this.valorFinanciamento = valorFinanciamento;
    }



    //construtor
    public Financiamento(double valorFinanciamento, int prazoFinanciamento, double taxaJurosAnual){
        this.valorFinanciamento=valorFinanciamento;
        this.prazoFinanciamento=prazoFinanciamento;
        this.taxaJurosAnual=taxaJurosAnual;
    }
    public double calcularPagamentoMensal(){
        double valorFinanciamento=this.valorFinanciamento;
        int prazoFinanciamento=this.prazoFinanciamento;
        double jurosAnual=this.taxaJurosAnual/100;
        return (valorFinanciamento/(prazoFinanciamento*12))*(1+(jurosAnual/12));
    }

    public double calcularTotalPagamento(){
        double parcela=calcularPagamentoMensal();
        int prazoFinanciamento=this.prazoFinanciamento;
        return  parcela*prazoFinanciamento*12;
    }
}
