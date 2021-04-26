import java.util.Scanner;
import java.io.IOException;

/*  URI: 2776  */
public class Promocoes {
     
    private static int unboundedKnapsack(int latas, int n, int[] value, int[] quantity) {         
        // dp[i] is going to store maximum valueue
        // with knapsack capacity i.
        int max[] = new int[latas+1];         
        
        // Fill dp[] using above recursive formula
        for(int i = 0; i <= latas; i++){
            for(int j = 0; j < n; j++){
                if(quantity[j] <= i ){ //need to check 
                    
                    max[i] = Math.max(max[i], max[i - quantity[j]] + value[j]);
                    //max[i] = Math.max(max[i], max[i - quantity[j]] + 1);
                    
                    //dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);         

                    //max { value(w-wi, i-1 }+vi , value(w, i-1) }
                    //max[i] = Math.max(max[i - quantity[j]], max[i-1] +  value[j]);
                }
            }
        }
        
        return max[latas];
        
    }


    public static int doesItFit(int W, int[] quantity, int[] value[]){



        return 0;
    }
    
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File(args[0]));   

        while (scanner.hasNext()){
            int promocoes = Integer.parseInt(scanner.next());
            int latas = Integer.parseInt(scanner.next());
            scanner.nextLine();
            int quantity[] = new int[promocoes];
            int value[] = new int[promocoes];

            for (int i=0; i < promocoes; i++){            
                quantity[i] = Integer.parseInt(scanner.next());
                value[i] = Integer.parseInt(scanner.next());
                scanner.nextLine();
            }                      


            System.out.println(unboundedKnapsack(latas, quantity.length, value, quantity));
            
        }
        scanner.close();
    }
}

