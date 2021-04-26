import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Supermercado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int total_lista = teclado.nextInt();
        teclado.nextLine(); //passa para proxima leitura de dados

        for (int i=0; i < total_lista; i++){
            List<String> lista = new ArrayList<>();
            String[] input = teclado.nextLine().split(" ");
      
            for (String s: input) {
                if (!lista.contains(s)) lista.add(s);
            }
            
            Collections.sort(lista);
        
            for (String elem: lista){ System.out.print(elem + " "); }
            System.out.println();
            lista.clear();            
        }   

        teclado.close();
    }
    
}
