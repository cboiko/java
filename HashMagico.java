import java.util.Scanner;
//import java.util.File;

public class HashMagico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File(args[0]));
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            int stringCount = Integer.parseInt(scanner.nextLine());
            int hashValue = 0;
            String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

            for (int j = 0; j < stringCount; j++){
                String word = scanner.nextLine();
                char[] c = word.toCharArray();
                for (int k=0; k < c.length; k++){
                    hashValue += alphabet.indexOf(c[k]);                    
                    hashValue += k;
                    hashValue += j;
                }
            }
            System.out.println(hashValue);
        }
        scanner.close();
    }
}
