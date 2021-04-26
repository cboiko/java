import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class OrdenaNumeros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>(); 
        int total = teclado.nextInt();
    
        for (int i=0; i < total; i++){
            int num = teclado.nextInt();
            if (num%2==0) pares.add(num);
                else impares.add(num);
        }
        
        teclado.close();
        Collections.sort(pares);
        Collections.sort(impares, Collections.reverseOrder());
    
        for (Integer elem: pares) { System.out.println(elem); }
        for (Integer elem: impares){ System.out.println(elem); }

    }

}