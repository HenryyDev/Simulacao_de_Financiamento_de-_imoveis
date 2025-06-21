package util;

public class InterfaceApartamento  extends  InterfaceUsuario{
    public int numeroAndar() {
        int numAndar = -1;
        while(numAndar <= 0) {
            System.out.println("Digite o número do andar (maior que 0): ");
            if (scan.hasNextInt()) {
               numAndar= scan.nextInt();
                if (numAndar <= 0) {
                    System.out.println("Número de andar inválido. Deve ser maior que 0");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scan.next();
            }
        }
        return numAndar;
    }

    @Override
    public int numeroVagas() {
        int numVagas = -1;
        while(numVagas <= 0) {
            System.out.println("Digite o número de vagas na garagem (maior que 0): ");
            if (scan.hasNextInt()) {
                numVagas= scan.nextInt();
                if (numVagas <= 0) {
                    System.out.println("Número de vagas inválido. Deve ser maior que 0");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scan.next();
            }
        }
        return numVagas;
    }
}
