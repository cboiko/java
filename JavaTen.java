import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;
/* Inferencia: capacidade de extrair o tipo da variavel sem casting */
/* var só pode ser utilizado em variaveis locais: for, while, try, block */
/* var nao pode ser utilizado como parametro  */
/* nao poder utilizada em variaveis nao inicializadas */
/* variaveis ficam no heapspace */
/* var sempre deve ser inicializad */
public class JavaTen {
    public static void main(String[] args) {
        connectPrint();
    }

    private static void connectPrint() {        
        try {
            var url = new URL("https://docs.oracle.com/javase/10/language");
            var urlConnection = url.openConnection();   
            var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            System.out.println(bufferedReader.lines()
            .collect(Collectors.joining()).replaceAll(">", "\n"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
