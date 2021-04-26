import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class NumerosRepetidos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cases = Integer.parseInt(teclado.next());
        Map<Integer, Integer> numeros = new TreeMap<>();

        for (int i = 0; i < cases; i++){
            int n = Integer.parseInt(teclado.next());
            int update = 1;
            if (numeros.get(n) != null) {
                update = numeros.get(n);
                update++;
            }
            numeros.put(n, update);
        }        
        teclado.close();
        
        for (Map.Entry<Integer, Integer> entry: numeros.entrySet())            
            System.out.println(entry.getKey() + " aparece " + entry.getValue() + " vez(es)");

    }
}
