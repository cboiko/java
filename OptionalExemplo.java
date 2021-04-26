/**
 * Optionals sao objetos que podem ser null
 * avoid NullPointerException
 */
import java.util.Optional;

public class OptionalExemplo {
    public static void main(String[] args) {
        Optional<String> optString = Optional.of("valor presente");
        System.out.println("Valor Opcional PRESENTE");
        optString.ifPresentOrElse(System.out::println, () -> System.out.println("Not presente"));

        Optional<String> optNull = Optional.ofNullable(null);

        System.out.println("Valor Opcional NAO presente");
        optNull.ifPresentOrElse(System.out::println, () -> System.out.println("Not presente"));

        Optional<String> empOptional = Optional.empty();
        System.out.println("Valor Opcional NAO presente");
        empOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Not presente"));

        Optional<String> optionalNull = Optional.of(null);
        System.out.println("Valor com null pointer");
        optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("Not presente"));
    }
    
}
