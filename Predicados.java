import java.util.function.Predicate;

public class Predicados {
    /**
     * Predicate recebe um parametro
     * retorna true or false
     * 
     */    
    public static void main(String[] args) {
        
        //Predicate<String> estaVazio = valor -> valor.isEmpty();
        /* metodo de referencia, trata diretamente o valor, referencia */
        Predicate<String> estaVazio = String::isEmpty;
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Cristiano"));
        
    }
    
}
