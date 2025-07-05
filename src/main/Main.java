package main;
import Serializacao.Persistencia;
import modelo.*;
import util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = null;
        boolean continuar = true;
        final String NOME_ARQUIVO_BIN = "financiamentos.bin";
        final String NOME_ARQUIVO_TXT="financiamento.txt";
        final String MENSAGEM_FINANCIAMENTO_ADICIONADO="Financiamento adicionado com sucesso.";
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        Object obj= Persistencia.lerObjeto(NOME_ARQUIVO_BIN);
        if (obj instanceof List<?>) {
            listaDeFinanciamentos = (List<Financiamento>) obj;
            System.out.println("Dados serializados carregados com sucesso.");
           ExibirFinanciamento.exibirFinanciamentos(listaDeFinanciamentos);
        }

        double somaValorImoveis = 0.0;
        double somaTotalFinanciamentos = 0.0;
        while (continuar) {
          int opcao = InterfaceMenuPrincipal.exibirMenu();
            if (opcao == 4) {
                LeituraEmTxt.lerFinanciamentos(NOME_ARQUIVO_TXT);
                continue;
            }
            if (opcao == 5) {
                System.out.println("encerrando...");
                continuar = false;
                break;
            }
            interfaceUsuario = switch (opcao) {
                case 1 -> new InterfaceCasa();
                case 2 -> new InterfaceApartamento();
                case 3 -> new InterfaceTerreno();
                default -> interfaceUsuario;
            };

            double valor = interfaceUsuario.valorImovel();
            int prazo = interfaceUsuario.prazoFinanciamento();
            double juros = interfaceUsuario.taxaJurosAnual();

            switch (opcao) {
                case 1:
                    double areaConstruida = interfaceUsuario.areaConstruida();
                    double areaTerreno = interfaceUsuario.areaTerreno();
                    Casa casa=new Casa(valor, prazo, juros, areaConstruida, areaTerreno);
                    listaDeFinanciamentos.add(casa);
                    SalvarEmTxt.salvarFinanciamento(casa,NOME_ARQUIVO_TXT);
                    Persistencia.salvarObjeto(listaDeFinanciamentos, NOME_ARQUIVO_BIN);
                    System.out.println(MENSAGEM_FINANCIAMENTO_ADICIONADO);
                    break;

                case 2:
                    int andar = interfaceUsuario.numeroAndar();
                    int vagas=interfaceUsuario.numeroVagas();
                    Apartamento ap=new Apartamento(valor, prazo, juros, andar, vagas);
                    listaDeFinanciamentos.add(ap);
                    SalvarEmTxt.salvarFinanciamento(ap,NOME_ARQUIVO_TXT);
                    Persistencia.salvarObjeto(listaDeFinanciamentos, NOME_ARQUIVO_BIN);
                    System.out.println(MENSAGEM_FINANCIAMENTO_ADICIONADO);
                    break;

                case 3:
                    String zona = interfaceUsuario.zonaTerreno(); // implementar
                    Terreno terreno=new Terreno(valor, prazo, juros, zona);
                    listaDeFinanciamentos.add(terreno);
                    SalvarEmTxt.salvarFinanciamento(terreno,NOME_ARQUIVO_TXT);
                    Persistencia.salvarObjeto(listaDeFinanciamentos, NOME_ARQUIVO_BIN);
                    System.out.println(MENSAGEM_FINANCIAMENTO_ADICIONADO);
                    break;
            }

            // Exibir e somar os dados de todos os financiamentos
            for (Financiamento f : listaDeFinanciamentos) {
                somaValorImoveis += f.getValorImovel();
                somaTotalFinanciamentos += f.calcularTotalPagamento();
            }
        }
            // Totais
            System.out.printf("\nTotal dos valores dos imóveis: R$ %.2f\n", somaValorImoveis);
            System.out.printf("Total dos valores dos financiamentos: R$ %.2f\n", somaTotalFinanciamentos);
    }

}
