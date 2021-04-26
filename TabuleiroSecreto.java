import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TabuleiroSecreto {

    public static int getFrequencia(HashMap<Integer, Integer> repeticoes){                        
        int maior = -1;
        int frequencia = 0; 
        
        for (Map.Entry<Integer, Integer> entry : repeticoes.entrySet()){
            if (entry.getValue() > frequencia){
                frequencia = entry.getValue();
                maior = entry.getKey();
            } else if (entry.getValue() == frequencia && entry.getKey() > maior){
                frequencia = entry.getValue();
                maior = entry.getKey();
            }
        }
        return maior;
    }
    

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int tamanhoTabuleiro = scr.nextInt();
        int operacoes = scr.nextInt();
        scr.nextLine();
        int[][] tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
        
        for (int i =0; i < tabuleiro.length; i++)
            for (int j = 0; j < tabuleiro.length; j++)
                tabuleiro[i][j] = 0;
        
        for (int i = 0; i < operacoes; i++){
            int operacao = scr.nextInt();

            //1 X R: Atribuir o valor R a todos os números da linha X;             
            if (operacao == 1) {
                int linha = scr.nextInt();
                int valor = scr.nextInt();                
                for (int j = 0; j < tabuleiro.length; j++)
                    tabuleiro[linha-1][j] = valor;
                scr.nextLine();
                continue;
            }
            // 2 X R: Atribuir o valor R a todos os números da coluna X;
            if (operacao == 2){
                int coluna  = scr.nextInt();
                int valor = scr.nextInt();
                for (int j = 0; j < tabuleiro.length; j++)
                    tabuleiro[j][coluna-1] = valor;
                scr.nextLine();
                continue;
            }
            //3 X: Imprimir o valor mais frequente na linha X;  
            if (operacao == 3){
                int linha = scr.nextInt();
                HashMap<Integer, Integer> numeros = new HashMap<>();
                for (int j = 0; j < tabuleiro.length; j++){
                    int key = tabuleiro[linha - 1][j];
                    if (numeros.containsKey(key))
                        numeros.put(key, numeros.get(key) + 1);
                    else numeros.put(key, 1);
                }
                //updateFrequencia(numeros, linha);
                System.out.println(getFrequencia(numeros));
                scr.nextLine();
                continue;
            }
            //4 X: Imprimir o valor mais frequente da coluna X.
            if (operacao == 4){                
                int coluna = scr.nextInt();                
                HashMap<Integer, Integer> numeros = new HashMap<>();
                for (int j = 0; j < tabuleiro.length; j++){
                    int key = tabuleiro[j][coluna -1];
                    if (numeros.containsKey(key))
                        numeros.put(key, numeros.get(key) + 1);
                    else
                        numeros.put(key, 1);
                }                    
                //updateFrequencia(numeros, coluna);
                System.out.println(getFrequencia(numeros));
                scr.nextLine();
                continue;
            }
        }
        scr.close();
    }
}