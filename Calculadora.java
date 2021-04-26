import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations = Integer.parseInt(scanner.nextLine());
        BigDecimal result = new BigDecimal("1.0");        
        for (int i=0; i < operations; i++){
            String input = scanner.nextLine();
            BigDecimal number = BigDecimal.valueOf(Double.parseDouble(input.split(" ")[0]));
            String op = input.split(" ")[1];
            if (op.equals("*"))
                result = result.multiply(number);
            else result = result.divide(number, MathContext.DECIMAL128);
        }        
        System.out.println(result.setScale(0, RoundingMode.DOWN));
        scanner.close();
    }    
}