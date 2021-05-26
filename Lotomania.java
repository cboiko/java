import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lotomania {

    static final String FILE_LOCATION_STRING = "D:\\loterias\\lotomania.csv";    
    static final String BETS_MADE = "D:\\loterias\\lotomania-done.txt";

    static int getHits(String loto, List<String> lines){
        int hits = 0;        
        List<Integer> lotoArray = getLotoArray(loto);

        for (String s : lines){
            List<Integer> row = getLotoArray(s);
            int counter=0;
            for (var number : lotoArray)
                if (row.contains(number))
                    counter++;
            
            if (counter == 0 || counter == 20 || counter == 19 || counter == 18)
                hits++;
                
        }
        return hits;
    }

    static double multiplyDouble(double number, int times){
        double result = 1;
        for (var i = 0; i < times; i++){
            result *= number;
        }
        return result;
    }

    static String getLotoProbability(String loto){
        TreeMap<Integer, Integer> sequences = new TreeMap<>();        
        sequences = getSequences(loto);      
        
        double acc = 1; //accumulator
        for (Map.Entry<Integer, Integer> entry : sequences.entrySet()){
            if (getProbability(entry.getKey()) < 100 ){ 
                double tempValue = (double) getProbability(entry.getKey()) / 100;
                acc *= multiplyDouble(tempValue, entry.getValue());
            }
                
        }
        return Double.toString(acc * 100);
    }

    static TreeMap<Integer, Integer> getSequences(String loto){
        TreeMap<Integer, Integer> sequences = new TreeMap<>();
        ArrayList<Integer> row = getLotoArray(loto);

        Collections.sort(row);
        
        for (int i = 0; i < 100; i++) {            
            int pos = -1;
            int last = -1;
            if (row.contains(i) && row.indexOf(i) != 0){
                pos = row.get(row.indexOf(i));
                last = row.get(row.indexOf(pos) - 1);
            } else if (row.contains(i) && row.indexOf(i) == 0) {
                pos = row.get(row.indexOf(i));
                last = 0;
            }

            int seq = 0;
            if (i == 99)
                seq = 99 - row.get(row.size() - 1);            

            if (pos > 0 && last >= 0)
                seq = pos - last;            
            
            if (seq != 0 && seq != 1)
                if (sequences.containsKey(seq))
                    sequences.put(seq, sequences.get(seq) + 1);
                else
                    sequences.put(seq, 1);            
        }
        return sequences;
    }

    static int getProbability(int sequenceParam){            
        List<String> lines = getLines();                        
        double lotoCounter=0;
        int sequenceCounter=0;
        
        for (String s : lines){
            TreeMap<Integer, Integer> sequences = getSequences(s);
            if (sequences.containsKey(sequenceParam))
                sequenceCounter += sequences.get(sequenceParam);
            
            lotoCounter++;
        }

        double percentage = (double) (sequenceCounter / lotoCounter) * 100;
        return (int) percentage;    
    }    
    
    static boolean checkExistingLoto(String loto) {
        ArrayList<Integer> arrayLoto = getLotoArray(loto);
        List<String> lines = getLines();
        
        for (String s : lines){
            ArrayList<Integer> rowArray = getLotoArray(s);
            if (arrayLoto.containsAll(rowArray)) return true;
        }

        return false;
    }

    static String createNewLotoSequence(int[] sequences) {
        String newLoto = "";
        Arrays.sort(sequences);
        do {
            newLoto = "";
            int random = (int) (Math.random() * 99);            
            ArrayList<Integer> numbersUsed = new ArrayList<>();
            numbersUsed.clear();

            //creating a sequence
            for (int number : sequences){
                while (numbersUsed.contains(random)) {
                    random = (int) (Math.random() * 99);
                }
                for (var j = random; j < (random + number); j++)
                    numbersUsed.add(j);
            }
                    
            //filling the remaining numbers
            Collections.sort(numbersUsed);
            var counter = numbersUsed.size();
            while (counter != 50){
                random = (int) (Math.random() * 99 );
                if (!numbersUsed.contains(random)){                    
                    counter++;
                    numbersUsed.add(random);
                }
            }
            Collections.sort(numbersUsed);

            for (var number : numbersUsed)
                newLoto += Integer.toString(number) + ",";
            
            newLoto = newLoto.substring(0, newLoto.length() - 1);            
            
        } while (checkExistingLoto(newLoto));
        
        return mirrorLoto(newLoto);
    }

    static String mirrorLoto(String loto){
        String mirrorLoto = "";
        ArrayList<Integer> numbers = getLotoArray(loto);

        for (int i = 0; i < 100; i++)
            if (!numbers.contains(i))
                mirrorLoto += Integer.toString(i) + ",";

        mirrorLoto = mirrorLoto.substring(0, mirrorLoto.length() - 1);
        
        return mirrorLoto;
    }

    static ArrayList<Integer> getLotoArray(String loto)  {
        String[] arrayString = loto.split(",");
        ArrayList<Integer> arrayLine = new ArrayList<>();
        for (String num : arrayString)
            try {
                arrayLine.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                System.out.println("NaN");
            }
            

        return arrayLine;
    }   

    static String toLotoArray(ArrayList<Integer> list){
        Collections.sort(list);
        String newLoto = "";
        for (var number : list)
                newLoto += Integer.toString(number) + ",";
            
            newLoto = newLoto.substring(0, newLoto.length() - 1);            
        return newLoto;
    }

    static List<String> getLines() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(FILE_LOCATION_STRING), StandardCharsets.UTF_8);                        
        } catch (Exception e) {
            e.printStackTrace();
        }
        //changing 100 to 0
        List<String> fixedLines = new ArrayList<>();
        for (String s : lines)
            fixedLines.add(s.replaceAll("100", "0"));
        
        return fixedLines;
    }

    static void checkOddEven(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(BETS_MADE), StandardCharsets.UTF_8);                        
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String s : lines){
            List<Integer> row = getLotoArray(s);
            int odd = 0;
            int even = 0;
            for (var number : row)
                if (number % 2 == 0) even++;
                else odd++;
    
            System.out.println(s);
            System.out.println("Even: " + even + " Odd: " + odd);
        }
         

    }

    static void checkWinner(String loto, List<String> lines){        
        List<Integer> lotoArray = getLotoArray(loto);
        // try {
        //     lines = Files.readAllLines(Paths.get(BETS_MADE), StandardCharsets.UTF_8);                        
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } 
                
        for (String s : lines){
            List<Integer> row = getLotoArray(s);
            int counter=0;
            for (var number : lotoArray)
                if (row.contains(number))
                    counter++;
            System.out.println(s);
            System.out.println("Hits: " + counter);
        }

    }
        
    static String createLoto(){
        ArrayList<Integer> arrayLoto = new ArrayList<>();
        int counter = 0;
        while (counter < 50){
            int random = (int) (Math.random() * 99);
            if (!arrayLoto.contains(random)){
                arrayLoto.add(random);
                counter++;
            }        
        }
        Collections.sort(arrayLoto);
        
        return Lotomania.toLotoArray(arrayLoto);

    }

    static List<String> createLotoFromFile(){
        List<String> lines = Lotomania.getLines();                
        List<String> allTickets = new ArrayList<>();

        int counter = 0;
        for (String first : lines) {
            ArrayList<Integer> numbers = new ArrayList<>(Lotomania.getLotoArray(first));
            counter++;
            for (int i = counter; i < lines.size(); i++){
                ArrayList<Integer> num = Lotomania.getLotoArray(lines.get(i));                
                for (int n : num){
                    if (!numbers.contains(n))
                        numbers.add(n);
                    if (numbers.size() == 50){                        
                        Collections.sort(numbers);
                        String numString = Lotomania.toLotoArray(numbers);
                        if (!allTickets.contains(numString))
                            allTickets.add(numString);
                        numbers.clear();
                        break;
                    }
                }
            }
        }

        return allTickets;

    }

    static void countOddEven(){
        List<String> lines = getLines();
        int maxOdd=0;
        int maxEven=0;
        for (String s : lines){
            List<Integer> row = getLotoArray(s);
            int odd = 0;
            int even = 0;
            for (var number : row)
                if (number % 2  == 0)
                    even++;
                else odd++;

            if (even > maxEven) maxEven = even;
            if (odd > maxOdd) maxOdd = odd;            
            if (even == 16) System.out.println(s + " " + lines.indexOf(s));
        }

        System.out.println("Max Odd " + maxOdd);
        System.out.println("Max Even " + maxEven);

    }
    
    public static <K, V extends Comparable<V> > Map<K, V> valueSort(final Map<K, V> map) {        
        Comparator<K> valueComparator = new Comparator<K>(){              
            public int compare(K k1, K k2){  
                int comp = map.get(k1).compareTo(map.get(k2));  
                if (comp == 0)
                     return 1;  
                else
                     return comp;
            }
        };

        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);  
        sorted.putAll(map);  
        return sorted;
    }

    static TreeMap<Integer,Integer> countNumbers(){
        List<String> lines = getLines();        
        TreeMap<Integer, Integer> numbers = new TreeMap<>();

        for (String s : lines ){            
            ArrayList<Integer> arrayLine = getLotoArray(s);

            for (int i = 1; i <= 100; i++) {
                if (arrayLine.contains(i))
                    if (numbers.containsKey(i))
                        numbers.put(i, numbers.get(i) + 1);
                    else numbers.put(i,1);
            }            
        }

        return numbers;
        
    }
    public static void main(String[] args) throws IOException {
        //AVERAGE_PROBABILITY = 4.3
        //PROBABILITY_AFTER_SEQUENCE = 8 (86%
        //AVERAGE_SEQ_SUM = 61
        final int AVERAGE_PROBABILITY_SEQ = 2; //Each loto has at least two sequences higher than 8
        final int AVERAGE_SEQUENCE_COUNT = 8; //Each loto has at least 8 sequences 
        final int[] SEQ = {8,12};
        boolean valid = false;
        String loto = "";

        
        while (true){            
            valid = false;            
            loto = createNewLotoSequence(SEQ);
            TreeMap<Integer, Integer> sequences = new TreeMap<>();
            sequences = getSequences(loto);
            
            ArrayList<Integer> keys = new ArrayList<>(sequences.keySet());
            int counter = 0;
            for (Integer i : keys)
                if (i > 8)
                    counter++;

            if (counter > AVERAGE_PROBABILITY_SEQ && sequences.size() >= AVERAGE_SEQUENCE_COUNT)
                valid = true;

            if (valid){
                FileWriter fw = new FileWriter("bets.txt", true);
                BufferedWriter writer = new BufferedWriter(fw);
                writer.write(loto + "\t");
                writer.write(getSequences(loto) + "\t");
                writer.write(getLotoProbability(loto) + "\t");
                writer.close();
                System.out.println(loto + " created.");
            }
        }

    }
}