package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1032 {

    class StreamChecker {

        private String[] words;
        private List<Integer>[] indexList;

        private StringBuilder querySb;

        public StreamChecker(String[] words) {
            int len = words.length;
            this.words = words;

            indexList = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                indexList[i] = new ArrayList<>();
            }

            for (int i = 0; i < len; i++) {
                String word = this.words[i];
                int curWorLen = word.length();
                indexList[word.charAt(curWorLen - 1) - 'a'].add(i);
            }

            querySb = new StringBuilder();
        }

        public boolean query(char letter) {
            querySb.append(letter);
            int querySbSize = querySb.length();

            for (Integer index: indexList[letter - 'a']) {
                String word = this.words[index];
                int len = word.length();
                if (len > querySbSize) {
                    continue;
                }
                if (querySb.substring(querySbSize - len, querySbSize).equals(word)) {
                    return true;
                }
            }

            return false;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
