import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.List;
//import java.io.File; //local validation
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AbreviacaoPost {    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in); 
        //Scanner scanner = new Scanner(new File(args[0]));   //local validation
        String input = scanner.nextLine();
        Map<String, String> words = new TreeMap<>();
        
        do {            
            List<String> inputArray = new ArrayList<>(Arrays.asList(input.split(" ")));
            for (String s : inputArray){
                    String key = s.toCharArray()[0]+".";                                        
                    if (words.containsKey(key)){
                        int actualFrequency =  Collections.frequency(inputArray, words.get(key));
                        int nextFrequency = Collections.frequency(inputArray, s);
                        int actualCharsReduced = actualFrequency * words.get(key).length() - (actualFrequency*2);
                        int nextCharsReduced = nextFrequency * s.length() - (nextFrequency*2);
                        if (nextCharsReduced > actualCharsReduced)
                            words.put(key, s);
                    }
                    else if (!words.containsKey(key) && s.length() > 2) { 
                        words.put(key, s); 
                    }
            }           
            /* abreviating the string */
            String abrev = "";
            for (int i=0; i < inputArray.size(); i++){
                String key = inputArray.get(i).toCharArray()[0]+".";
                if (words.containsValue(inputArray.get(i))){
                    inputArray.set(i, words.get(key));
                    abrev = abrev.concat(key + " ");
                } else { abrev = abrev.concat(inputArray.get(i) + " "); }                    
                
            }
            System.out.println(abrev.trim());            
            System.out.println(words.size());
            words.entrySet().forEach( entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
            inputArray.clear();
            words.clear();
            input = scanner.nextLine();
        } while (!input.equals("."));
        scanner.close();
    }
}