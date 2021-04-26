import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class FilaBanco {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int casos = teclado.nextInt();
        teclado.nextLine();
        List<Integer> total_mods = new ArrayList<>();

        for (int i = 0; i < casos; i++) {                        
            int clientes = teclado.nextInt();
            teclado.nextLine();
            String input[] = teclado.nextLine().split(" ");                        
            List<Integer> original_list = new ArrayList<>();

            for (String s: input) original_list.add(Integer.parseInt(s));
            
            List<Integer> modified_list = new ArrayList<>(original_list);

            Collections.sort(modified_list, Collections.reverseOrder());

            int mods = 0;            
            for(int j=0; j < clientes; j++)
                if (original_list.get(j) != modified_list.get(j)){
                    mods++;
                } 
            
            total_mods.add(clientes - mods);
        }

        teclado.close();

        for(Integer i: total_mods) System.out.println(i);

    }
    
}
