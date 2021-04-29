import java.util.ArrayList;
import java.util.List;

public class LotomaniaCombination {
    
    static void combination(int[] elements, int k) {

        int N = elements.length; // get the length of the array e.g. for {'A','B','C','D'} => N = 4        
        int pointers[] = new int[k]; // init combination index array
        int r = 0; // index for combination array
        int i = 0; // index for elements array
        int combinationCount=0;
        StringBuilder sb = new StringBuilder();
        while (r >= 0) {

            // forward step if i < (N + (r-K))
            if (i <= (N + (r - k))) {
                pointers[r] = i;

                // if combination array is full print and increment i;
                if (r == k - 1) {
                    sb.setLength(0);
                    for (int j=0; j < pointers.length; j++){
                        sb.append(elements[pointers[j]]);
                        sb.append(",");
                    }
                    //sb.setCharAt(sb.length()-1, ' ');
                    System.out.println(sb.toString());                    
                    i++;
                } else {
                    // if combination is not full yet, select next element
                    i = pointers[r] + 1;
                    r++;
                }
            }

            // backward step
            else {
                r--;
                if (r >= 0)
                    i = pointers[r] + 1;

            }
        }
        System.out.println(combinationCount);
    }

    public static void main(String[] args) {
        int lotoArr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
                53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
                79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};        

        int testeArr[] = {1,2,3,4,5};
        int k = 3;
                
        combination(lotoArr, 3);
        //System.out.println(size);
    }
}