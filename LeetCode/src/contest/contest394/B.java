package contest.contest394;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    public int numberOfSpecialChars(String word) {
        int[] smallLastIdxArr = new int[26];
        int[] bigFirstIdxArr = new int[26];
        char[] arr = word.toCharArray();
        int len = arr.length;
        Arrays.fill(smallLastIdxArr, -1);
        Arrays.fill(bigFirstIdxArr, len);
        boolean[] big = new boolean[26];
        boolean[] small = new boolean[26];
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (Character.isLowerCase(c)) {
                small[c - 'a'] = true;
                smallLastIdxArr[c - 'a'] = Math.max(i, smallLastIdxArr[c - 'a']);
            } else {
                big[c - 'A'] = true;
                bigFirstIdxArr[c - 'A'] = Math.min(i, bigFirstIdxArr[c - 'A']);
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (big[i] && small[i] && smallLastIdxArr[i] < bigFirstIdxArr[i]) {
                ans++;
            }
        }
        return ans;
    }

}
