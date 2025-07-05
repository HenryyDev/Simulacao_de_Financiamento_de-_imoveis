package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraEmTxt {
    public static void lerFinanciamentos(String nomeArquivo){
        try(BufferedReader leitura = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;
            while ((linha= leitura.readLine())!=null){
                String [] todosOsCampos=linha.split(";");
                System.out.println("\nTipo:" + todosOsCampos[0]);
                for(int i=1;i<todosOsCampos.length;i++){
                    String [] campoEValor=todosOsCampos[i].split("=");
                    if(campoEValor.length==2){
                        String nomeDoCampo=campoEValor[0].toLowerCase();
                        String valorDoCampo=campoEValor[1];
                        switch (nomeDoCampo){
                            case "valor":
                                //converte a string para double ou int se for o caso
                                String valorCorrigido=valorDoCampo.replace(",",".");
                                System.out.printf("Valor Do imóvel/terreno: R$ %.2f \n",Double.parseDouble(valorCorrigido));
                                break;
                            case "total":
                                String totalCorrigidio=valorDoCampo.replace(",",".");
                                System.out.printf("Valor total do financiamento: R$ %.2f \n",Double.parseDouble(totalCorrigidio));
                                break;
                            case "prazo":
                                System.out.printf("Prazo: %d anos \n", Integer.parseInt(valorDoCampo));
                                break;
                            case "juros":
                                System.out.printf("Juros: %.2f%% ao ano \n",Double.parseDouble(valorDoCampo));
                                break;
                            case "area":
                                System.out.printf("Área construída: %.2f m²\n", Double.parseDouble(valorDoCampo));
                                break;
                            case "terreno":
                                System.out.printf("Área do terreno: %.2f m²\n", Double.parseDouble(valorDoCampo));
                                break;
                            case "andar":
                                System.out.printf("Andar: %s\n", valorDoCampo);
                                break;
                            case "vagas":
                                System.out.printf("Vagas de garagem: %s\n", valorDoCampo);
                                break;
                            case "zona":
                                System.out.printf("Zona: %s\n", valorDoCampo);
                                break;
                        }
                    }
                }
            }
        }catch (IOException e){
            System.out.println("ERRO NA LEITURA: "+e.getMessage());
        }
    }
}
