package contest.contest140;

import java.util.ArrayList;
import java.util.List;

public class Problem1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ansList = new ArrayList<>();

        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                ansList.add(words[i+2]);
            }
        }

        return ansList.toArray(new String[0]);
    }
    
    public static void main(String[] args) {

    }
    
}
