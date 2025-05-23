public class Financiamento {
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

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
