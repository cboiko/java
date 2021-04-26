import java.util.Scanner;

public class ParesPositivos {
    public static void main(String[] args) {
        int pos = 0;
        int neg = 0;
        int par = 0;
        int impar = 0;

        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++){
            int num = Integer.parseInt(teclado.nextLine());           
            
            if (num > 0) pos++; else if (num < 0) neg++; 
            if (num % 2 == 0) par++; else impar++;
        }        
        teclado.close();
        System.out.println(par + " valor(es) par(es)");
        System.out.println(impar + " valor(es) impar(es)");
        System.out.println(pos + " valor(es) positivo(s)");
        System.out.println(neg + " valor(es) negativo(s)");

        //List<Integer> valores = new ArrayList<>();
        //System.out.println(valores.stream().filter((valor)-> valor.intValue()%2==0).count() + " numeros pares");
        //System.out.println(valores.stream().filter((valor)-> valor.intValue()%2!=0).count() + " numeros impares");
        //System.out.println(valores.stream().filter((valor)-> valor.intValue()>0).count() + " valores positivos");
        //System.out.println(valores.stream().filter((valor)-> valor.intValue()<0).count() + " valores negativos");        
    }
}
