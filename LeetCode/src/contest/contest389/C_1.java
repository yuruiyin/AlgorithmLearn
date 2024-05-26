package contest.contest389;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_1 {

    public int minimumDeletions(String word, int k) {
        char[] arr = word.toCharArray();
        int[] countArr = new int[26];
        for (char c : arr) {
            countArr[c - 'a']++;
        }

        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (countArr[i] == 0) {
                continue;
            }
            countList.add(countArr[i]);
        }

        Collections.sort(countList);
        int size = countList.size();
        int ans = Integer.MAX_VALUE;
        int preSum = 0;
        for (int i = -1; i < size - 1; i++) {
            if (i >= 0) {
                preSum += countList.get(i);
            }
            int value = 0;
            for (int j = size - 1; j >= i + 2; j--) {
                int diff = countList.get(j) - countList.get(i + 1);
                if (diff > k) {
                    value += diff - k;
                } else {
                    break;
                }
            }
            ans = Math.min(ans, preSum + value);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C_1().minimumDeletions("dabdcbdcdcd", 2));
    }

}
