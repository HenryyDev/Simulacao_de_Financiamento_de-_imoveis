package util;
import java.util.Scanner;

public class InterfaceMenuPrincipal {
    private static final Scanner scan = new Scanner(System.in);

    public static  int exibirMenu(){
        int opcao= -1;
        System.out.println("\nEscolha o tipo de imóvel:");
        System.out.println("1 - Casa");
        System.out.println("2 - Apartamento");
        System.out.println("3 - Terreno");
        System.out.println("4 - Ver financiamentos salvos");
        System.out.println("5 - Sair");
        while (opcao < 1 || opcao > 5) {
            System.out.print("Digite a opção desejada (1 a 5): ");
            if (scan.hasNextInt()) {
                opcao = scan.nextInt();
            } else {
                System.out.println("Entrada inválida!");
                scan.next();
            }
        }
        return opcao;
    }
}
