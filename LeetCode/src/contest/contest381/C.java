package contest.contest381;

import java.util.Arrays;

public class C {

    public int minimumPushes(String word) {
        int[] countArr = new int[26];
        char[] arr = word.toCharArray();
        for (char c : arr) {
            countArr[c - 'a']++;
        }

        Arrays.sort(countArr);
        int ans = 0;
        int curCount = 0;
        int idx = 1;
        for (int i = 25; i >= 0; i--) {
            if (countArr[i] == 0) {
                break;
            }

            if (curCount < 8) {
                curCount++;
                ans += idx * countArr[i];
            } else {
                idx++;
                curCount = 1;
                ans += idx * countArr[i];
            }
        }
        return ans;
    }

}
