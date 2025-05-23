import  java.util.Scanner;
public class InterfaceUsuario {
    Scanner scan=new Scanner(System.in);
    public double valorImovel(){
        System.out.print("Digite o valor do imovel: ");
        return scan.nextDouble();
    }
    public int prazoFinanciamento(){
        System.out.print("Digite o prazo do financiamento (EM ANOS): ");
        return scan.nextInt();
    }
    public double taxaJurosAnual(){
        System.out.print("Digite a taxa de juros anual: ");
        return scan.nextDouble();
    }
}
