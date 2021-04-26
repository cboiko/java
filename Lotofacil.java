import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Lotofacil {
    static final String FILE_LOCATION_STRING = "/home/boiko/loterias/lotofacil.csv";

    static ArrayList<Integer> getLotoArray(String loto){
        String[] arrayString = loto.split(",");
        ArrayList<Integer> arrayLine = new ArrayList<>();
        for (String num : arrayString)
            arrayLine.add(Integer.parseInt(num));
        
        return arrayLine;
    }

    static void printOpposite(){
        List<String> lines = getLines();
        int totalLines = lines.size();
        TreeMap<Integer, Integer> numbers = new TreeMap<>();

        for (String s : lines ){            
            ArrayList<Integer> arrayLine = getLotoArray(s);

            for (int i = 1; i <= 25; i++) {
                if (!arrayLine.contains(i))
                    if (numbers.containsKey(i))
                        numbers.put(i, numbers.get(i) + 1);
                    else numbers.put(i,1);
            }
        }

        numbers.entrySet().forEach( entry -> {
            System.out.println(entry.getKey() + ": " + ((double) entry.getValue() / totalLines) * 100 + "%"); 
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

    static void countLoto() {
        List<String> lines = getLines();
        try {            
            Scanner scanner = new Scanner(new File(FILE_LOCATION_STRING));
            while (scanner.hasNext()){
                int counter = 0;
                String row = scanner.nextLine();
                counter = Collections.frequency(lines, row);
                if (counter > 1)
                    System.out.println(row + " occurrences: " + counter);
            }
        } catch (IOException e) { e.printStackTrace(); }        
    }


    static boolean checkExistingLoto(ArrayList<Integer> arrayLoto) {
        Scanner scanner;        
        try {
            scanner = new Scanner(new File(FILE_LOCATION_STRING));
            while (scanner.hasNext()) {
                ArrayList<Integer> arrayRow = getLotoArray(scanner.nextLine());

                if (arrayLoto.containsAll(arrayRow))
                    return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
        return false;
    }
    
    public static void main(String[] args) {

        ArrayList<Integer> newLoto = new ArrayList<>();
        int counter = 0;
        while (counter != 15) {
            int random  = (int) (Math.random() * 25);
            if (!newLoto.contains(random) && random != 0){
                newLoto.add(random);
                counter++;
            }
                
        }
        Collections.sort(newLoto);
        System.out.println(newLoto);
        System.out.println(checkExistingLoto(newLoto));        
       
    }
    
}
