package contest.contest202;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/16
 */
public class D_1 {

    private Map<Integer, Integer> memoMap;

    private int dp(int n) {
        if (n <= 1) {
            return n;
        }

        if (memoMap.containsKey(n)) {
            return memoMap.get(n);
        }

        int ansMin = Math.min(dp(n / 3) + n % 3 + 1, dp(n / 2) + n % 2 + 1);
        memoMap.put(n, ansMin);
        return ansMin;
    }

    public int minDays(int n) {
        memoMap = new HashMap<>();
        return dp(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new D_1().minDays(429));
        System.out.println(new D_1().minDays(764));
    }

}
