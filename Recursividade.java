import java.util.HashMap;
import java.util.Map;
public class Recursividade {
    static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();
    public static void main(String[] args) {
        /**
         * Cada funcao chama a si mesma ate uma condicao de parada
         */
        System.out.println(fatorial(5));
        System.out.println(fatorialMapa(15));

    }
    /* empilhamento de execucao */
    public static int fatorial(int numero){
        if (numero == 1) return numero;
        else return numero * fatorial(numero - 1);
    }

    /* Tail Cail: recursividade em cauda, not supported by JVM */

    /* Memoization: cache dos resultados de entrada com Mapa */
    public static Integer fatorialMapa(Integer value){
        if (value ==1) return value;
        else {
            if (MAPA_FATORIAL.containsKey(value)) {
                return MAPA_FATORIAL.get(value);
            } else {
                Integer result = value * fatorialMapa(value -1);
                MAPA_FATORIAL.put(value, result);
                return result;
            }
        }

    }
}
