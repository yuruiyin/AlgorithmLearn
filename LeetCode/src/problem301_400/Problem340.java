package problem301_400;

import java.util.HashMap;
import java.util.Map;

public class Problem340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        char[] arr = s.toCharArray();
        int len = arr.length;

        int left = 0;
        int right = k > len ? len - 1 : k - 1;
        for (int i = left; i <= right; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        int ansMax = right - left + 1;
        while (right < len) {
            while (++right < len) {
                countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);
                int diffCharCount = countMap.keySet().size();
                if (diffCharCount > k) {
                    break;
                }

                int length = right - left + 1;
                if (length > ansMax) {
                    ansMax = length;
                }
            }

            if (right == len) {
                return ansMax;
            }

            // 不同字符个数超出k个了,left需要右移
            while (left <= right - k) {
                int count = countMap.get(arr[left]) - 1;
                if (count == 0) {
                    countMap.remove(arr[left]);
                } else {
                    countMap.put(arr[left], count);
                }

                left++;
                int diffCharCount = countMap.keySet().size();
                if (diffCharCount <= k) {
                    break;
                }
            }

        }

        return ansMax;
    }

}
