package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;

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
        return valorImovel;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    private double taxaJurosAnual;

    //construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel=valorImovel;
        this.prazoFinanciamento=prazoFinanciamento;
        this.taxaJurosAnual=taxaJurosAnual;
    }
    public double calcularPagamentoMensal(){
        double valorImovel=this.valorImovel;
        int prazoFinanciamento=this.prazoFinanciamento;
        double jurosAnual=this.taxaJurosAnual;
        return (valorImovel/(prazoFinanciamento*12))*(1+(jurosAnual/12));
    }

    public double calcularTotalPagamento(){
        double parcela=calcularPagamentoMensal();
        int prazoFinanciamento=this.prazoFinanciamento;
        return  parcela*prazoFinanciamento*12;
    }
}
