import java.io.IOException;
import java.util.Scanner;

public class ValoresPositivos {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);        
        int positivos = 0;
        for (int i=1; i<=6;i++){
            double a = Double.parseDouble(teclado.nextLine());
            if (a > 0) { positivos++; }
        }
        teclado.close();
        System.out.println(positivos + " valores positivos");

    }
}
