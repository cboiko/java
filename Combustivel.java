import java.util.Scanner;
public class Combustivel {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int distancia = Integer.parseInt(teclado.nextLine());//km
        double combustivel = Double.parseDouble(teclado.nextLine()); //l
        double consumo = distancia/combustivel;
        teclado.close();
        System.out.println(String.format("%.3f", consumo) + " km/l");
    }
}
