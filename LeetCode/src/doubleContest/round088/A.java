package doubleContest.round088;

import java.util.HashSet;
import java.util.Set;

public class A {

    private boolean isOk(String str) {
        int[] countArr = new int[26];
        for (char c : str.toCharArray()) {
            countArr[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) {
                set.add(countArr[i]);
            }
        }
        return set.size() == 1;
    }

    public boolean equalFrequency(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            String str;
            if (i == 0) {
                str = word.substring(1);
            } else if (i == len - 1) {
                str = word.substring(0, word.length() - 1);
            } else {
                str = word.substring(0, i) + word.substring(i + 1);
            }
            if (isOk(str)) {
                return true;
            }
        }
        return false;
    }

}
