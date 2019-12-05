package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem438 {

    private boolean isMatch(int[] pCount, int[] tmpCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != tmpCount[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int sLen = s.length();
        int pLen = p.length();

        if (pLen > sLen) {
            return new ArrayList<>();
        }

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        for (int i = 0; i < pLen; i++) {
            pCount[pArr[i] - 'a']++;
        }

        int[] tmpCount = new int[26];
        int left = 0;
        int right = pLen - 1;

        for (int i = left; i <= right; i++) {
            tmpCount[sArr[i] - 'a']++;
        }

        List<Integer> ansList = new ArrayList<>();
        if (isMatch(pCount, tmpCount)) {
            ansList.add(left);
        }

        boolean lastIsMatch = ansList.size() == 1;
        while ((++right) < sLen) {
            left++;
            tmpCount[sArr[left-1] - 'a']--;
            tmpCount[sArr[right] - 'a']++;

            if (sArr[left-1] == sArr[right]) {
                if (lastIsMatch) {
                    ansList.add(left);
                }
                continue;
            }

            if (isMatch(pCount, tmpCount)) {
                lastIsMatch = true;
                ansList.add(left);
            } else {
                lastIsMatch = false;
            }
        }

        return ansList;
    }
}
