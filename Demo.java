import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo{
    //Function finding first non-repeated character in a string
    static void firstNonRepeatedCharacter(String str){
        //Declare string variables
        String upperCaseString;
        String sortedString = "";
        //convert input string to upper case so it easily compare each character in string
        upperCaseString = str.toUpperCase();
        //Create a hash map, find each character's frequency, put each character as key and its frequency as value
        HashMap<Character, Integer>hm = new HashMap<>(upperCaseString.length());
        for(int i = 0; i < upperCaseString.length(); i++){
            //If hash map contain character, increment it frequency
            if(hm.containsKey(upperCaseString.charAt(i))){
                hm.put(upperCaseString.charAt(i), hm.get(upperCaseString.charAt(i))+1);
            }
            //Otherwise, set it frequency to 1
            else{
                hm.put(upperCaseString.charAt(i), 1);
            }
        }
        //Print out the first non-repeated character
        for(int j = 0; j < upperCaseString.length(); j++){
            //If we find the first non-repeated character, print it out and we break out of loop
            if(hm.get(upperCaseString.charAt(j)) == 1){
                System.out.println("The first non repeated character is: " + str.charAt(j));
                break;
            }
            //Prompt the user if there is no non-repeated character in an inputed string
            if(j == upperCaseString.length()-1){
                System.out.println("The string has no non repeated");
            }
        }
        
        //Construct an ArrayList holding all the entry object of Hash Map hm
        ArrayList<Entry<Character, Integer>> entryList = new ArrayList<>(hm.entrySet());
        //Sorting the entryList based on values
        Collections.sort(entryList, new Comparator<Entry<Character, Integer>>(){
            @Override
            public int compare(Entry<Character, Integer> c1, Entry<Character, Integer> c2){
                return c1.getValue().compareTo(c2.getValue());
            }
        });
        //Print out the sorted string descending based on its frequency
        for(Entry<Character, Integer> entry : entryList){
            int fre = entry.getValue();
            while(fre >= 1){
                sortedString += entry.getKey();
                fre = fre - 1;
            }
        }
        System.out.println("The sorted string based on its frequency is: " + sortedString);
    }
    
    //Main function where the entry point of code execution started
    public static void main(String[] args) {
        String strInput;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a string");
        strInput = sc.nextLine();
        firstNonRepeatedCharacter(strInput);
        
    }
}
