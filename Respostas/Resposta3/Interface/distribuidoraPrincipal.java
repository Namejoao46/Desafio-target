package Respostas.Resposta3.Interface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Respostas.Resposta3.Calculos.menorFaturamento;
import Respostas.Resposta3.Calculos.maiorFaturamento;
import Respostas.Resposta3.Calculos.calculoDiaBom;
import Respostas.Resposta3.Calculos.FaturamentoDiario;

public class distribuidoraPrincipal {
    public static void main(String[] args) {
        List<FaturamentoDiario> faturamentos = leitorDJason("faturamento.json");

        if (faturamentos.isEmpty()){
            System.out.println("Nenhum faturamento encontrado");
            return;
        }

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o que deseja averiguar: ");
        System.out.println(" 1 - Calcular Menor Faturamento");
        System.out.println(" 2 - Calcular Maior Faturamento");
        System.out.println(" 3 - Calcular dias com Faturamento Acima da Média");
        int relatorio = scanner.nextInt();

        switch (relatorio){
            case 1:
                 menorFaturamento calculaMenor = new menorFaturamento();
                 double menor = calculaMenor.calcularMenor(faturamentos);
                 System.out.println("Menor faturamento do mês: " + menor);
                 break;

            case 2:
                maiorFaturamento calculaMaior = new maiorFaturamento();
                double maior = calculaMaior.calcularMaior(faturamentos);
                System.out.println("Menor faturamento do mês: " + maior);
                break;

            case 3:
                calculoDiaBom calculadiasbons = new calculoDiaBom();
                int diasAcimaMedia = calculadiasbons.calculardiabom(faturamentos);
                System.out.println("Número de dias com faturamento acima da média: " + diasAcimaMedia);
                break;

            default:
                System.out.println("Opção inválida.");
        }
        scanner.close();

    }

private static List<FaturamentoDiario> leitorDJason(String caminhoArquivo) {
        List<FaturamentoDiario> faturamentos = new ArrayList<>();

        //leitura de arquivos para evitar uso de dependencias
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                
                // Removendo caracteres indesejados e separando por chaves e vírgulas
                linha = linha.replaceAll("[\\[\\]{}]", "");
                String[] elementos = linha.split(",");

                // Extraindo os valores de dia e valor
                for (String elemento : elementos) {
                    if (elemento.contains("\"dia\"")) {
                        int dia = Integer.parseInt(elemento.split(":")[1].trim());
                        double valor = Double.parseDouble(elementos[1].split(":")[1].trim());
                        faturamentos.add(new FaturamentoDiario(dia, valor));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return faturamentos;
    }
}