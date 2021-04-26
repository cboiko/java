import java.util.Scanner;

public class ValidarSenha {    
    public static void main(String[] args) {
        Scanner teclado = new Scanner( System.in);

        while (teclado.hasNext()) {
            String senha = teclado.nextLine();
            boolean valid = false;

            valid = senha.length() < 6 ? false : senha.length() > 32 ? false : true;
            if (senha.contains(" ")) valid = false;
            if (senha.matches("(.*)\\p{Punct}(.*)")) valid = false;
            if (!senha.matches("(.*)\\p{Alnum}(.*)")) valid = false;
            if (!senha.matches(".*[A-Z].*")) valid = false;
            if (!senha.matches(".*[a-z].*")) valid = false;
            if (!senha.matches(".*[1-9].*")) valid = false;

            if (valid) System.out.println("Senha valida.");
            else System.out.println("Senha invalida.");
        }
        teclado.close();
    }
}
