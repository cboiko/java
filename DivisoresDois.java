import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivisoresDois {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        br.close();   

        
        int result = -1;       
        if (c%a == 0){            
            int sqrt = (int)Math.sqrt(c);
            for(int i=a; i <= c; i = i+a){                
                if (i%a==0 && i%b!=0 && c%i==0 && d%i != 0 ){
                    result = i;
                    break;
                }         
                if (i == sqrt){
                    result = c;
                    break;
                }
            }
        }
        System.out.println(result);        
    }    
}