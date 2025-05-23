public class Main {
    public static void main(String[] args) {
        //puxa dados que o usuario digitar
        InterfaceUsuario interfaceUsuario=new InterfaceUsuario();
        double valorImovel= interfaceUsuario.valorImovel();
        int prazoFinanciamento=interfaceUsuario.prazoFinanciamento();
        double taxaJurosAnual=interfaceUsuario.taxaJurosAnual();
        //instancia o obj financiamento
        Financiamento financiamento = new Financiamento(valorImovel,prazoFinanciamento,taxaJurosAnual);
        double parcela=financiamento.calcularPagamentoMensal();
        double total=financiamento.calcularTotalPagamento();
        System.out.printf("Parcela mensal aproximada: R$ %.2f\n", parcela);
        System.out.printf("Total a pagar ao final do financiamento: R$ %.2f\n", total);
    }
}