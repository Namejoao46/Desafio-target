package Respostas.Resposta5.Interface;
import Respostas.Resposta5.leitura.LeituraDeValor;
import Respostas.Resposta5.modificador.Inversor;
public class Interface {

    public static void main(String[] args) {
        //texto original
        LeituraDeValor leitor = new LeituraDeValor();
        String textoOriginal = leitor.capturaString();

        //texto invertido
        Inversor inversor = new Inversor();
        String textoInvertido = inversor.inverter(textoOriginal);

        //saida
        System.out.println("String original: " + textoOriginal);
        System.out.println("String invertida: " + textoInvertido);
    }
}