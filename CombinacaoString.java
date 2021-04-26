import java.util.Scanner;
//import java.io.File;
import java.io.FileNotFoundException;
public class CombinacaoString {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File(args[0]));
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            String input = scanner.nextLine();
            char[] first = input.split(" ")[0].toCharArray();
            char[] second = input.split(" ")[1].toCharArray();
            /* transforms the two strings */
            String terceira = "";            
            if (first.length >= second.length){
                for (int j =0; j<second.length; j++){
                    String a = String.valueOf(first[j]);
                    String b = String.valueOf(second[j]);
                    terceira = terceira.concat(a).concat(b);
                }
                String rest = String.valueOf(first, second.length, first.length - second.length);
                terceira = terceira.concat(rest);
            } else { //second > first
                for (int j =0; j<first.length; j++) {
                    String a = String.valueOf(first[j]);
                    String b = String.valueOf(second[j]);
                    terceira = terceira.concat(a).concat(b);
                }
                String rest = String.valueOf(second, first.length, second.length - first.length);
                terceira = terceira.concat(rest);
            }
            System.out.println(terceira);
        }
        scanner.close();    
    }
}
