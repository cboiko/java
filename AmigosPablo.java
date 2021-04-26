import java.util.Scanner;
import java.util.TreeSet;
public class AmigosPablo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        TreeSet<String> amigos_sim = new TreeSet<>();        
        TreeSet<String> amigos_nao = new TreeSet<>();        
        String input = teclado.nextLine();
        String melhor_amigo = "";
        int maior = 0;
        do { 
            if (input.contains("SIM")){
                if (input.length() > maior){
                    melhor_amigo = input;
                    maior = input.length();
                }
                amigos_sim.add(input.split(" ")[0]);
            } else amigos_nao.add(input.split(" ")[0]);            
            input = teclado.nextLine();
        } while (!input.equals("FIM"));
        
        amigos_sim.remove("Abhay");
        for(String s: amigos_sim) System.out.println(s);
        for(String s: amigos_nao) System.out.println(s);
        System.out.println();
        System.out.println("Amigo do Pablo:");
        System.out.println(melhor_amigo.split(" ")[0]);
        teclado.close();
    }
}
