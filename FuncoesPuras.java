import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class FuncoesPuras {
    public static void main(String[] args) {

        /* Funcoes Puras */
        BiPredicate<Integer, Integer> higherThan =
            (parametro, valor) -> parametro > valor;
        
        System.out.println(higherThan.test(13, 12));
        System.out.println(higherThan.test(13, 12));
        
        /* Imutabilidade */
        int valor = 20;
        UnaryOperator<Integer> dobro = v -> v*2;
        System.out.println(dobro.apply(valor));
        System.out.println(valor);

        /* you can't change values inside functions */

        /**
         * Funcoes declarativas
         * Function<parametro, retorno>
         */
        //Function<Integer, Object> buscarUsuario = idUser ->
            //buscar usuario
            //new Object();

        

    }

}