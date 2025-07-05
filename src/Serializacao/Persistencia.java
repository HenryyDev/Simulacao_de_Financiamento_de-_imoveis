package Serializacao;
import java.io.*;

public class Persistencia {
    public static void salvarObjeto(Object obj, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(obj);
            System.out.println("\nObj serializado e salvo com sucesso em: " + nomeArquivo);
        }
        catch (IOException e) {
            System.out.println("Erro ao salvar obj: " + e.getMessage());
        }

    }

    public static Object lerObjeto(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: nenhum financiamento salvo ainda.");
        } catch (EOFException e) {
            System.out.println("Arquivo vazio: ainda não há dados salvos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe dos objetos salvos não encontrada.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return null;
    }
}

