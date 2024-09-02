package Respostas.Resposta5.modificador;

public class Inversor {
    
    public String inverter(String original){
    
        char[] caracteres = original.toCharArray();
            
        int n1 = 0, n2 = caracteres.length - 1;

        while (n1 < n2 ){
            char temp = caracteres[n1];
            caracteres[n1] = caracteres[n2];
            caracteres[n2] = temp;

            n1++;
            n2--;
        }

        return new String(caracteres);
    } 
}
