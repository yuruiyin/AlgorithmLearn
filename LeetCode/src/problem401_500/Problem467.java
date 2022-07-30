package problem401_500;

import java.util.Map;

public class Problem467 {

    public int findSubstringInWraproundString(String p) {
        char[] arr = p.toCharArray();
        int len = arr.length;
        int preCount = 1;
        int[] countArr = new int[26];
        countArr[arr[0] - 'a']++;
        for (int i = 1; i < len; i++) {
            if ((arr[i - 1] - 'a' + 1) % 26 == (arr[i] - 'a') % 26) {
                preCount++;
            } else {
                preCount = 1;
            }
            if (preCount > countArr[arr[i] - 'a']) {
                countArr[arr[i] - 'a'] = preCount;
            }
//            countArr[arr[i] - 'a'] = Math.max(countArr[arr[i] - 'a'], preCount);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += countArr[i];
        }
        return sum;
    }

}
