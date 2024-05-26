package doubleContest.round130;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {

    private int[] memo;
    private char[] arr;
    private int len;

    private int dp(int idx) {
        if (idx == len) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        Map<Character, Integer> countMap = new HashMap<>();
        int resMin = len - idx;
        for (int i = idx; i < len; i++) {
            char c = arr[i];
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            int count = -1;
            boolean isOk = true;
            for (char tmpC: countMap.keySet()) {
                int tmpCount = countMap.get(tmpC);
                if (count == -1) {
                    count = tmpCount;
                } else {
                    if (tmpCount != count) {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) {
                resMin = Math.min(resMin, 1 + dp(i + 1));
            }
        }

        return memo[idx] = resMin;
    }

    public int minimumSubstringsInPartition(String s) {
        this.arr = s.toCharArray();
        this.len = arr.length;
        memo = new int[1001];
        Arrays.fill(memo, -1);
        return dp(0);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
