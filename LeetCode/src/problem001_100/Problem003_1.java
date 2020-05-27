package problem001_100;

import java.util.Arrays;

/**
 * Problem003_1
 *
 * @author: yry
 * @date: 2020/5/2
 */
public class Problem003_1 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;

        int left = 0;
        int[] indexMap = new int[128];
        Arrays.fill(indexMap, -1);
        indexMap[arr[0]] = 0;
        int ansMaxLen = 1;
        for (int right = 1; right < len; right++) {
            char c = arr[right];
            if (indexMap[c] != -1 && indexMap[c] >= left) {
                left = indexMap[c] + 1;
            } else {
                ansMaxLen = Math.max(ansMaxLen, right - left + 1);
            }
            indexMap[c] = right;
        }
        return ansMaxLen;
    }

}
