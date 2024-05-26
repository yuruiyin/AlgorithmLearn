package contest.contest389;

import java.util.*;

public class C {

    public int minimumDeletions(String word, int k) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        int[] countArr = new int[26];
        for (int i = 0; i < len; i++) {
            countArr[arr[i] - 'a']++;
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


        int ans = 0;
        int preSum = 0;
        for (int i = size - 1; i >= 1; i--) {
            int diff = countList.get(i) - countList.get(0);
            if (diff > k) {
                ans += diff - k;
            } else {
                break;
            }
        }

        for (int i = 0; i < size - 1; i++) {
            preSum += countList.get(i);
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
        System.out.println(new C().minimumDeletions("dabdcbdcdcd", 2));
    }

}
