import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class EntrevistaDois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String value = scanner.nextLine();
            Set<String> results = new TreeSet<>();
                       
            int limit = (int) value.length() / 2;
            boolean found = false;
            for (int i = 1; i <= limit; i++) {
                String pattern = value.substring(value.length()-i);
                String repeat = value.substring(value.length()-(2*i),value.length()-i);
                if (pattern.equals(repeat)) {                    
                    results.add(value.substring(0,value.length()-i));
                    found = true;
                } 
            }
            if (!found) System.out.println(value);
            else results.stream().forEach(System.out::println);
        }
        scanner.close();        
    }    
}