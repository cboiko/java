import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
        
    Consumer<String> imprimiFrase = frase -> System.out.println(frase);
    imprimiFrase.accept("dont think, just coonsume!");

    /* Metodo de referencia, esconde parametro */
    Consumer<String> imprimeOutraFrase = System.out::println;
    imprimeOutraFrase.accept("coonsume sem parametro");

    }
    
}
