import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Aluno implements Comparable<Aluno> {
    protected String nome;
    protected String camisa;

    Aluno (String n, String c) {
        this.nome = n;
        this.camisa = c;
    }
    public String getNome(){ return this.nome;}
    public String getCamisa(){ return this.camisa; }
    @Override public String toString(){ return(this.camisa + " " + this.nome); }

    @Override public int compareTo(Aluno al){ return this.getNome().compareTo(al.getNome()); }

}

public class Uniformes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();

        int qtdUniformes = teclado.nextInt();
        teclado.nextLine();
        /* leitura dos dados */
        while(qtdUniformes != 0) {
            for (int i = 0; i < qtdUniformes; i++){
                String nome = teclado.nextLine();
                String camisa = teclado.nextLine();                
                alunos.add(new Aluno(nome, camisa));
            }
            qtdUniformes = teclado.nextInt();
        }        
        teclado.close();

        Collections.sort(alunos);
        
        /* imprimindo dados*/
        String tam[] = {"branco P", "branco M", "branco G", "vermelho P", "vermelho M", "vermelho G"};
        
        for (String s: tam)
            for (Aluno al: alunos)
                if (al.getCamisa().equals(s)) { System.out.println(al); }
    }    
}