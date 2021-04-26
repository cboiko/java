import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConjuntoBom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();        
        List<String> input = new ArrayList<>();
        do {
            boolean good = true;
            input.clear();
            for (int i = 0; i < cases; i++){
                String word = scanner.next().toLowerCase();
                for (String s: input)
                    if ((s.startsWith(word) || word.startsWith(s))) { good = false; }                
                input.add(word);
            }            
            if (good) System.out.println("Conjunto Bom");
            else System.out.println("Conjunto Ruim");            
            cases = scanner.nextInt();
        } while (cases != 0);
        scanner.close();
    }    
}
