import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Alunos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int qtdUniformes = teclado.nextInt();
        Map<String, String> uniformes = new TreeMap<>();        

        teclado.nextLine();
        /* leitura de dados */
        while(qtdUniformes != 0){
            for (int i=0; i < qtdUniformes; i++){
                String nome = teclado.nextLine();
                String tamanho = teclado.nextLine();
                uniformes.put(nome, tamanho);
              }            
            qtdUniformes = teclado.nextInt();            
        }        
        teclado.close();

        /* exbicao de dados */
        String tam[] = {"branco P", "branco M", "branco G", "vermelho P", "vermelho M", "vermelho G"};
    
        for (String t: tam)
            if (uniformes.containsValue(t))
                for( Map.Entry<String, String> entry : uniformes.entrySet())
                    if (entry.getValue().equals(t)) { System.out.println(t + " " + entry.getKey()); }

    }    
}
