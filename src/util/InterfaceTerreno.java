package util;

public class InterfaceTerreno  extends InterfaceUsuario{
    public String zonaTerreno(){
    String zona;
    while (true){
        System.out.println("Digite a zona do terreno (Residencial, Comercial ou Industrial): ");
        zona= scan.nextLine().trim();
        if (zona.equalsIgnoreCase("Residencial") ||
                zona.equalsIgnoreCase("Comercial") ||
                zona.equalsIgnoreCase("Industrial")) {
            return zona.substring(0, 1).toUpperCase() + zona.substring(1).toLowerCase();
        } else {
            System.out.println("Zona inválida! Digite uma das opções: Residencial, Comercial ou Industrial.");
        }
    }
    }
    }
