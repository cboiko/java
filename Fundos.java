/**
 * A primeira linha contem um inteiro N (1 ≤ N ≤ 105 ) representando o número possível de convidados. 
 * Cada uma das próximas N linhas descreve um possível candidato com três inteiros B, F e D (1 ≤ B, F, D ≤ 109 ), 
 * indicando respectivamente seu nivel de beauty, sua fortune e quanto esta pessoa doaria caso fosse convidada.
 * 
 * Toda vez que alguém assim encontra uma pessoa rigorosamente mais bonita, mas não rigorosamente mais rica, então uma discussão começa
 * 
 * Assim, duas pessoas nunca discutirão caso uma seja estritamente mais bonita e mais rica que a outra. 
 * Também não ocorrem discussões quando ambas as pessoas são igualmente ricas e igualmente bonitas. 
 * 
 * Imprima uma única linha contendo um inteiro que indica a soma máxima de doações possíveis para uma lista de convidados 
 * que não gere discussão alguma durante o evento.
 * 
 * beleze fortune donation
 * 
 * 4
 * 1 2 50  
 * 2 1 50
 * 2 2 30
 * 1 1 30
 * 
 * Saida: 60
 * 
 * 98  102 102
 * 100 100 0
 * 99  101 0
 * 102
 * 
 * 
 * 
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fundos {
    static class Convidado {
        int beauty;
        int fortune;
        int donation;
        int total;
        Convidado(int b, int f, int d){ this.beauty = b; this.fortune = f; this.donation = d; total = 0;}
        public int calculaTotal(List<Convidado> convidadoList){            
            for (Convidado c: convidadoList)
                if ((c.beauty == this.beauty && c.fortune == this.fortune) || (c.beauty < this.beauty && c.fortune < this.fortune)){
                    total += c.donation;                     
                }
            else continue;             
            return total;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeConvidados = scanner.nextInt();
        scanner.nextLine();        
        int maxTotal = 0;
        List<Convidado> convidados = new ArrayList<>();
        

        for (int i=0; i < quantidadeConvidados; i++){
            convidados.add(new Convidado(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));            
        }

        for (Convidado c: convidados){
            int totalConvidado = c.calculaTotal(convidados);            
            maxTotal = (totalConvidado > maxTotal) ? totalConvidado : maxTotal;
        }

        System.out.println(maxTotal);
        scanner.close();
    }
}

