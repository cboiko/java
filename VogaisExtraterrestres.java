import java.util.Scanner;
public class VogaisExtraterrestres {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while (teclado.hasNext()){
            char[] vogais = teclado.nextLine().toCharArray();
            String frase = teclado.nextLine();
            int quantidade = 0;
            
            for (char c : vogais)
                for (int i = 0; i < frase.length(); i++)
                    if (frase.charAt(i) == c) quantidade++;
            
            System.out.println(quantidade);
        }
        teclado.close();
    }    
}