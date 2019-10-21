package interview_tencent.round04;

import java.util.Arrays;

public class Problem01 {

    public int firstUniqChar(String s) {
        int n = s.length();
        if (n == 0) {
            return -1;
        }

        int[] countArr = new int[26];
        int[] indexArr = new int[26];

        Arrays.fill(indexArr, -1);

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            countArr[index]++;
            indexArr[index] = i;
        }

        Arrays.sort(indexArr);

        for (int i = 0; i < 26; i++) {
            if (indexArr[i] != -1) {
                if (countArr[s.charAt(indexArr[i]) - 'a'] == 1) {
                    return indexArr[i];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem01().firstUniqChar("leetcode"));
        System.out.println(new Problem01().firstUniqChar("loveleetcode"));
    }
    
}
