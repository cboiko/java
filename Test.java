import java.util.List;

public class Test {
       
    public static void main(String[] args) {
        //String loto="0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,22,25,26,27,28,29,30,31,32,33,34,35,36,38,39,40,50,51,52,54,55,69,70,71,72,75,80,82,83,84,85,94,98,99";
        String loto = "";
        int[] arr  = {4};
        int hits = 0;
        while (hits == 0){
            loto = Lotomania.createNewLotoSequence(arr);
            hits = Lotomania.getHits(loto);
        }
        System.out.println(loto);
        System.out.println(Lotomania.getHits(loto));
    }
}