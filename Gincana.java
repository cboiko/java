import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gincana {
    public static void main(String[] args) {        
        List<String> alunos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int qtdAlunos = teclado.nextInt(); teclado.nextLine();
        
        while (qtdAlunos != 0) {
            for (int  i=0; i < qtdAlunos; i++) alunos.add(teclado.nextLine());

            int removeIndex = 0;
            int actualIndex = 0;
            int actualValue = Integer.parseInt(alunos.get(actualIndex).split(" ")[1]);
            for (int  i=0; i < qtdAlunos-1; i++){
                if (actualValue % 2 == 0 ) {
                    removeIndex = (alunos.size() - (actualValue % alunos.size()) + actualIndex) % alunos.size();
                } else {
                    removeIndex = (actualValue % alunos.size() + actualIndex) % alunos.size();
                }                
                actualValue = Integer.parseInt(alunos.get(removeIndex).split(" ")[1]);
                alunos.remove(removeIndex);

                /* update actual Index*/
                if (actualValue % 2 == 0){
                    if (removeIndex <= (alunos.size()-1)){
                        actualIndex = removeIndex;
                    } else {actualIndex = 0;}
                } else if (removeIndex == 0){
                    actualIndex = alunos.size()-1;
                } else { actualIndex = removeIndex -1;}
            }     
            System.out.println("Vencedor(a): " + alunos.get(0).split(" ")[0]);
            alunos.clear();
            qtdAlunos = teclado.nextInt(); teclado.nextLine();
        }
        teclado.close();
    }
}