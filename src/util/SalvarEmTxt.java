package util;

import modelo.Financiamento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarEmTxt {
    public static void salvarFinanciamento(Financiamento f,String nomeArquivo) {
        try (BufferedWriter escrever=new BufferedWriter(new FileWriter(nomeArquivo,true))){
                escrever.write(f.toString());
                escrever.newLine();

        }catch (IOException e){
            System.out.println("ERRO AO SALVAR: "+e.getMessage());
        }

    }
}
