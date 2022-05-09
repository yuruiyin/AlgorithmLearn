package problem501_600;

import java.util.Arrays;

public class Problem567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] countArr1 = new int[26];
        int len1 = s1.length();
        for (char c : s1.toCharArray()) {
            countArr1[c - 'a']++;
        }

        char[] arr2 = s2.toCharArray();
        int len2 = arr2.length;
        int[][] preCountArr2 = new int[len2][26];
        preCountArr2[0][arr2[0] - 'a']++;
        if (len1 == 1) {
            return s2.contains(s1);
        }
        for (int i = 1; i < len2; i++) {
            for (int j = 0; j < 26; j++) {
                preCountArr2[i][j] = preCountArr2[i - 1][j] + (arr2[i] - 'a' == j ? 1 : 0);
            }
            if (i + 1 >= len1) {
                int[] tmpCountArr = new int[26];
                for (int j = 0; j < 26; j++) {
                    tmpCountArr[j] = preCountArr2[i][j] - (i + 1 == len1 ? 0 : preCountArr2[i - len1][j]);
                }
                if (Arrays.equals(tmpCountArr, countArr1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem567().checkInclusion("ab", "eidbaooo"));
    }

}
