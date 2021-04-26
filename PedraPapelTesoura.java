import java.util.Scanner;
public class PedraPapelTesoura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); 
        int cases = teclado.nextInt(); teclado.nextLine();
        
        for (int i=0; i < cases; i++) {
            String[] input = teclado.nextLine().split(" ");
            String fer = input[0];
            String mar = input[1];
            Boolean winner = false;
            switch (fer){
                case "tesoura": 
                    if (mar.equals("papel") || mar.equals("lagarto")){ System.out.println("fernanda"); winner = true; }
                    if (mar.equals("pedra") || mar.equals("spock")) { System.out.println("marcia"); winner = true; }
                    break;
                case "papel":
                    if (mar.equals("pedra") || mar.equals("spock")) { System.out.println("fernanda"); winner = true; }
                    if (mar.equals("lagarto") || mar.equals("tesoura")) { System.out.println("marcia"); winner = true; }
                    break;
                case "lagarto":  
                    if (mar.equals("spock") || mar.equals("papel")) { System.out.println("fernanda"); winner = true; }
                    if (mar.equals("tesoura") || mar.equals("pedra")) { System.out.println("marcia"); winner = true; }
                    break;
                case "spock": 
                    if (mar.equals("tesoura") || mar.equals("pedra")) { System.out.println("fernanda"); winner = true; }
                    if (mar.equals("papel") || mar.equals("lagarto")) { System.out.println("marcia"); winner = true; }
                    break;
                case "pedra":
                    if (mar.equals("lagarto") || mar.equals("tesoura")) { System.out.println("fernanda"); winner = true; }
                    if (mar.equals("papel") || mar.equals("spock")) { System.out.println("marcia"); winner = true; }
                    break;                                    
            }
            if (!winner) System.out.println("empate");
        }
        teclado.close();
    }
}