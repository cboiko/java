import java.util.function.UnaryOperator;

public class Funcional {
    public static void main(String[] args) {
        UnaryOperator<Integer> calc_tres = valor -> valor*3; //conceito funcional
        int valor = 10;
        System.out.println("Resultado ::" + calc_tres.apply(valor));
    }
    
}
