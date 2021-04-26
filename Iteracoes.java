import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class Iteracoes {
    /**
     * 
     * String[] e String... mesma coisa
     * .sorted((p1, p2)->p1.x.compareTo(p2.x)) 
     */

   
    public static void main(String[] args) {
        String[] nomes = {"Joao", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
        Integer[] numeros = {1,2,3,4,5};    
        imprimeNomesFiltrados(nomes);
        //Stream.of(nomes).forEach(System.out::println);
        Stream.of(nomes).forEach(nome -> System.out.println("foreach: "+nome));
        /* numeros */
        Stream.of(numeros).map(numero -> numero * 2).forEach(System.out::println);

        List<String> listaProf = new ArrayList<>();
        listaProf.add("Dev");
        listaProf.add("Test");
        listaProf.add("PO");
        listaProf.add("PM");

        listaProf.stream()
            .filter(profissao -> profissao.startsWith("P"))
            .forEach(System.out::println);

    }   

    public static void imprimeNomesFiltrados(String... nomes){
        /* classe abstrata nao pode ser instanciada */
        String imprimeNomes = Stream.of(nomes)
            .filter(nome -> nome.equals("Paulo"))
            .collect(Collectors.joining()); //coleta array de strings com espaco
        System.out.println(imprimeNomes);
    }
}


