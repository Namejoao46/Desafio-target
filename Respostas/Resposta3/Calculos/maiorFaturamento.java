package Respostas.Resposta3.Calculos;
import java.util.List;

public class maiorFaturamento {
    
    public double calcularMaior(List <FaturamentoDiario> faturamentos){
        double maiorFaturamento = Double.MIN_VALUE;

        for (FaturamentoDiario fatura : faturamentos){
            if (fatura.getValorDia() > 0 && fatura.getValorDia() > maiorFaturamento){
                maiorFaturamento = fatura.getValorDia();
            }
        }

        return maiorFaturamento;
    }
    
}