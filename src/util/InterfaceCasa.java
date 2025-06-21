package util;
public class InterfaceCasa extends InterfaceUsuario {
    public double areaConstruida() {
        double area = -1;
        while (area <= 0) {
            System.out.println("Digite a área construida em m² (maior que 0): ");
            if (scan.hasNextDouble()) {
                area = scan.nextDouble();
                if (area <= 0) {
                    System.out.println("Área inválida. Deve ser maior que 0");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scan.next();
            }
        }
        return area;
    }

    public double areaTerreno() {
        double area = -1;
        while (area <= 0) {
            System.out.println("Digite o tamanho do terreno em m² (maior que 0): ");
            if (scan.hasNextDouble()) {
                area = scan.nextDouble();
                if (area <= 0) {
                    System.out.println("Tamanho inválido. Deve ser maior que 0");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                scan.next();
            }
        }
        return area;
    }
}
