package Respostas.Resposta5.leitura;
import java.util.Scanner;

public class LeituraDeValor {

    public String capturaString(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a string que deseja inverter : ");

        String texto = scanner.nextLine();
        scanner.close();

        return texto;
    }
    
}
