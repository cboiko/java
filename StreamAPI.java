/**
 * Manipulacao de collections com paradigma funcioanl
 * Nao altera colecao original
 * mapping: colecao com o mesmo tamanho de origem
 * filtering: filtra colecao
 * foreach: executa uma logica para cada elemento
 * peek: retorna a propria colecao depois de atualizar
 * grouping: retorna uma colecao agrupada
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.*;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> estudantes = new ArrayList<>();

        estudantes.add("Cristiano");
        estudantes.add("Alessandro");
        estudantes.add("Fabio");
        estudantes.add("Roberto");
        estudantes.add("Lucio");
        estudantes.add("Carolina");
        estudantes.add("Maria");
        estudantes.add("Joao");

        System.out.println("Contagem " + estudantes.stream().count());
        System.out.println("Letras max: " + estudantes.stream().max(Comparator.comparingInt(String::length)));        
        System.out.println("Letras min: " + estudantes.stream().min(Comparator.comparingInt(String::length)));
        System.out.println("Filter R: " + estudantes.stream().filter((estudante) ->
            estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
        //Retorna uma nova colecao com os concatenados a quantida de letras de cada nome
        System.out.println("Nova colecao com quantidade de letras: " + 
            estudantes.stream().map(estudante ->
            estudante.concat(" - ").concat(String.valueOf(estudante.length())))
            .collect(Collectors.toList()));
        System.out.println("3 primeiros elementos: "+ estudantes.stream().limit(3).collect(Collectors.toList()));
        //exibe cada elemento no console
        System.out.println("For each: ");
        estudantes.stream().forEach(System.out::println);
        System.out.println("Contem W: " + estudantes.stream().allMatch((elemento) -> elemento.contains("W")));
        System.out.println("Contem a: " + estudantes.stream().anyMatch((elemento) -> elemento.contains("a")));
        System.out.println("minuscula nome: " + estudantes.stream().noneMatch((elemento) -> elemento.contains("a")));        
        //retorna o primeiro elemento se existir no console
        System.out.print("primeiro elemento se existir: ");
        estudantes.stream().findFirst().ifPresent(System.out::println);

        //operacoes encadeadas:
        System.out.print("operacao encadeada: ");
        System.out.println(estudantes.stream()
        .peek(System.out::println)
        .map(
            estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
        .peek(System.out::println)
        .filter((estudante) ->estudante.toLowerCase().contains("r"))
        //.collect(Collectors.toList())
        .collect(Collectors.groupingBy( estudante -> estudante.substring(estudante.indexOf("-", +1)))));
    }
}
