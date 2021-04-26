import java.util.Scanner;

public class Weblogger {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while(teclado.hasNext()){
            String input = teclado.nextLine();
            
            while (input.contains("*")){
                input = input.replaceFirst("\\*", "<b>");
                input = input.replaceFirst("\\*", "</b>");                
            }

            while (input.contains("_")){
                input = input.replaceFirst("_", "<i>");
                input = input.replaceFirst("_", "</i>");                
            }

            System.out.println(input);            
        }
        teclado.close();        
    }    
}