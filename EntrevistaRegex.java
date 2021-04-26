import java.util.Scanner;

public class EntrevistaRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String value = scanner.nextLine();            
            System.out.println(value.replaceAll("(.+?)\\1+", "$1"));
        }
        scanner.close();        
    }    
}