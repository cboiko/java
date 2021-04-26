import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Palavras {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int testes = scr.nextInt(); scr.nextLine();

        for (int i = 0; i< testes; i++){            
            List<String> input = new ArrayList<>(Arrays.asList(scr.nextLine().split(" ")));            
            String inverted = input.stream()
                .sorted(Comparator.comparing(String::length).reversed().thenComparing(Comparator.naturalOrder()))                                
                .collect(Collectors.joining(" "));
            System.out.println(inverted);
        }
        scr.close();
    }
}

