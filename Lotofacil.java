import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Lotofacil {
    static final String FILE_LOCATION_STRING = "D:\\loterias\\lotofacil.csv";

    static ArrayList<Integer> getLotoArray(String loto){
        String[] arrayString = loto.split(",");
        ArrayList<Integer> arrayLine = new ArrayList<>();
        for (String num : arrayString)
            arrayLine.add(Integer.parseInt(num));
        
        return arrayLine;
    }

    static void countNumbers(){
        List<String> lines = getLines();        
        TreeMap<Integer, Integer> numbers = new TreeMap<>();

        for (String s : lines ){            
            ArrayList<Integer> arrayLine = getLotoArray(s);

            for (int i = 1; i <= 25; i++) {
                if (arrayLine.contains(i))
                    if (numbers.containsKey(i))
                        numbers.put(i, numbers.get(i) + 1);
                    else numbers.put(i,1);
            }            
        }

        numbers.entrySet().forEach( entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue()); 
        });
        
    }

    //create method getLines    
    static List<String> getLines(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(FILE_LOCATION_STRING), StandardCharsets.UTF_8);                                    
        } catch (Exception e) { e.printStackTrace(); }
        return lines;
    }

    static boolean checkExistingLoto(ArrayList<Integer> arrayLoto) {
        List<String> lines = getLines();
        
        for (String s : lines) {
            ArrayList<Integer> arrayRow = getLotoArray(s);
            if (arrayLoto.containsAll(arrayRow))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {

        // ArrayList<Integer> newLoto = new ArrayList<>();
        // int counter = 0;
        // while (counter != 15) {
        //     int random  = (int) (Math.random() * 25);
        //     if (!newLoto.contains(random) && random != 0){
        //         newLoto.add(random);
        //         counter++;
        //     }
                
        // }
        countNumbers();
       
    }
    
}
