import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Divisores {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        br.close();   

        int result = -1;
        //if( a != b && c != d && a <= c){
        if (c % a == 0){
            int end = c;
            int start = a;
            while(start <= end){
                if(start % a==0 && start%b!=0 && c%start==0 && d%start!=0){
                
                    result = start;
                    break;
                }
                start += a;
            }
        }
        System.out.println(result);        
    }    
}