import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LotomaniaCombination {    
    
    static void combination(int[] elements, int k) throws IOException {

        int N = elements.length; // get the length of the array e.g. for {'A','B','C','D'} => N = 4        
        int pointers[] = new int[k]; // init combination index array
        int r = 0; // index for combination array
        int i = 0; // index for elements array
        FileWriter fw = new FileWriter("D:\\allBets.txt", true);
        BufferedWriter writer = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();
        List<String> lines = Lotomania.getLines();
        int maxHits = 0;
        while (r >= 0) {
            
            if (i <= (N + (r - k))) {
                pointers[r] = i;
                
                if (r == k - 1) {
                    sb.setLength(0);
                    for (int j=0; j < pointers.length; j++){
                        sb.append(elements[pointers[j]]);
                        sb.append(",");
                    }
                    int hits =  Lotomania.getHits(sb.toString(), lines);
                    if (hits > maxHits) maxHits = hits;
                    sb.append(Integer.toString(hits));
                    writer.write(sb.toString());
                    i++;
                    break; //testing the first line
                } else {                    
                    i = pointers[r] + 1;
                    r++;
                }
            }

            else {
                r--;
                if (r >= 0)
                    i = pointers[r] + 1;

            }
        }
        writer.close();
        System.out.println("Max Hits: " + maxHits);
    }

    public static void main(String[] args) {
        int lotoArr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
                53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
                79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};        

        try {
            combination(lotoArr, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}