package problem801_900;

import java.util.HashSet;
import java.util.Set;

public class Problem804 {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] pwdTable = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---", ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(pwdTable[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }

}
