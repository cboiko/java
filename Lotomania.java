import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lotomania {

    static final String FILE_LOCATION_STRING = "/home/boiko/loterias/lotomania.csv";    

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

    static ArrayList<Integer> getLotoArray(String loto) {
        String[] arrayString = loto.split(",");
        ArrayList<Integer> arrayLine = new ArrayList<>();
        for (String num : arrayString)
            arrayLine.add(Integer.parseInt(num));

        return arrayLine;
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

    public static void main(String[] args) throws IOException {
        //AVERAGE_PROBABILITY = 4.3
        //PROBABILITY_AFTER_SEQUENCE = 8 (86%
        //AVERAGE_SEQ_SUM = 61
        final int AVERAGE_PROBABILITY_SEQ = 2; //Each loto has at least two sequences higher than 8
        final int AVERAGE_SEQUENCE_COUNT = 8; //Each loto has at least 8 sequences 
        final int[] SEQ = {4,8,12};
        boolean valid = false;
        String loto = "";

        
        while (true){            
            valid = false;            
            long startTime = System.currentTimeMillis();
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
                long endTime = System.currentTimeMillis();
                FileWriter fw = new FileWriter("bets.txt", true);
                BufferedWriter writer = new BufferedWriter(fw);
                writer.write(loto + "\t");
                writer.write(getSequences(loto) + "\t");
                writer.write(getLotoProbability(loto) + "\t");
                writer.write("Time: " + ((endTime-startTime)/1000) + " seconds" + "\n");
                writer.close();
                System.out.println(loto + " created.");
            }
        }
        

    }
}