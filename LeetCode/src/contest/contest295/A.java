package contest.contest295;

import java.util.Arrays;
import java.util.Map;

public class A {

    public int rearrangeCharacters(String s, String target) {
        char[] arr = target.toCharArray();
        int[] countArr = new int[26];
        for (char c: arr) {
            countArr[c - 'a']++;
        }
        int[] countArr1 = new int[26];
        for (char c : s.toCharArray()) {
            countArr1[c - 'a']++;
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) {
                minCount = Math.min(minCount, countArr1[i] / countArr[i]);
            }
        }
        return minCount;
    }

}
