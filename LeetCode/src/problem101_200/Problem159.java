package problem101_200;

import java.util.HashMap;
import java.util.Map;

public class Problem159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len <= 2) {
            return len;
        }

        char[] arr = s.toCharArray();
        int k = 2;
        Map<Character, Integer> countMap = new HashMap<>();
        int ansMax = k;
        int left = 0;
        int right = k - 1;

        for (int i = left; i <= right; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        while (right < len) {
            while (countMap.keySet().size() <= k) {
                right++;
                if (right == len) {
                    break;
                }
                countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);
            }

            int curLen = right - left;
            if (curLen > ansMax) {
                ansMax = curLen;
            }

            if (right == len) {
                break;
            }

            // right右移后，当前不同字符的个数大于k了,因此需要left也右移
            while (countMap.keySet().size() > k) {
                if (countMap.get(arr[left]) == 1) {
                    countMap.remove(arr[left]);
                } else {
                    countMap.put(arr[left], countMap.get(arr[left]) - 1);
                }
                left++;
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem159().lengthOfLongestSubstringTwoDistinct("abc"));
        System.out.println(new Problem159().lengthOfLongestSubstringTwoDistinct("abcabcabc"));
        System.out.println(new Problem159().lengthOfLongestSubstringTwoDistinct("eceba"));
    }

}
