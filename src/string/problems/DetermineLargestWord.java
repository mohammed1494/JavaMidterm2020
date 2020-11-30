package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
        //implement
        String [] word = s.split(" ");
        String maxWord = "";
        for(int i = 0; i < word.length; i++){
            if(word[i].length() >= maxWord.length()){
                maxWord = word[i];
            }
        }
        System.out.println(maxWord);
    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st="Human brain is a biological learning machine";;
        //implement
        String [] word = st.split(" ");
        String maxWord = "";
        for(int j = 0; j < word.length; j++){
            if(word[j].length() >= maxWord.length()){
                maxWord = word[j];
            }
        }
        System.out.println(maxWord);

        return map;
    }
}
