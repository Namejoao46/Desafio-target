package Respostas.Resposta1;

public class PrimeiraResposta {
    public static void main(String[] args) {
        int INDICE = 13, SOMA = 0, K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
           
        }

        System.out.println("O resultado final e igual a = " + SOMA);
    }
}