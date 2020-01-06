package contest.contest104;

import java.util.ArrayList;
import java.util.List;

public class Problem916 {

    public List<String> wordSubsets(String[] arrA, String[] arrB) {
        int[] countArr = new int[26];

        for (String str: arrB) {
            int[] tmpCountArr = new int[26];
            for (char c: str.toCharArray()) {
                tmpCountArr[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                countArr[i] = Math.max(countArr[i], tmpCountArr[i]);
            }
        }

        List<String> ansList = new ArrayList<>();
        for (String word: arrA) {
            int[] tmpCountArr = new int[26];
            for (char c: word.toCharArray()) {
                tmpCountArr[c - 'a']++;
            }

            boolean isMatch = true;
            for (int i = 0; i < 26; i++) {
                if (tmpCountArr[i] < countArr[i]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                ansList.add(word);
            }
        }

        return ansList;
    }

}
