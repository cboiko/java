import java.util.function.Function;

public class Funcoes {
    /** Function<Parametro, Retorno> 
     * (o1,o2)-> o1.compareTo(o2)
     *  .sorted((o1, o2) -> o1.getAge() - o2.getAge())
    */
    public static void main(String[] args) {
        Function<String, String> backwardsName = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> stringToInt = texto -> Integer.valueOf(texto) * 2; //multiply by 2
        System.out.println(backwardsName.apply("Cristiano"));
        System.out.println(stringToInt.apply("20"));

        //sort((first, second) -> first.getIdade() - second.getIdade());
        //sort(Comparator.comparingInt(Estudante::getIdade));
        //sort(Comparator.comparingInt(Estudante::getIdade).reversed());
        //Collections.sort(estudantes) --comparable: dentro de uma classe de dominio
        //Collections.sort(estudantes, new EstudanteComparator()) --comparator

    }
}
