import java.util.Scanner;

public class ValidarSenhaRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senha = scanner.nextLine();


        if(senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,32}$")) {
            System.out.println("Senha valida.");
         } else {
            System.out.println("Senha invalida.");
         
        }
        scanner.close();
    }    
}
