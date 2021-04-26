import java.util.Scanner;

public class Entrevista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         while(scanner.hasNext()){
            String value = scanner.nextLine();
            String pattern = "";
            String cleanString = "";
            boolean found = false;
            /* pesquisa pelo padrao que se repete */
            for (int i=value.length()-1; i>0; i--){
                pattern = value.substring(i);
                cleanString = value.substring(0,i);
                if (!cleanString.contains(pattern)){
                    cleanString = value.substring(0,i+1);
                    found = true;
                    System.out.println(cleanString);                    
                    break;
                }
            }            
            if (!found) System.out.println(value);
        }
        scanner.close();        
    }    
}