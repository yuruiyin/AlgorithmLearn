package problem1101_1200;

import java.util.HashMap;
import java.util.Map;

public class Problem1140 {

    private Map<String, Integer> memoMap = new HashMap<>();

    private int backTrack(int[] piles, int from, int M, boolean isMineTurn) {
        if (from == piles.length) {
            return 0;
        }

        String key = from + "," + M + "," + isMineTurn;

        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (piles.length - from <= 2*M) {
            int sum = 0;
            if (isMineTurn) {
                for (int i = from; i < piles.length; i++) {
                    sum += piles[i];
                }
            }
            memoMap.put(key, sum);
            return sum;
        }

        int min = Integer.MAX_VALUE; // 对方回合，因为他足够聪明，因此，需要取最小值
        int max = Integer.MIN_VALUE;
        int beforeSum = 0;
        for (int i = from; i < from + 2 * M && i < piles.length; i++) {
            beforeSum += piles[i];
            int m = Math.max(M, i - from  + 1);
            int res = backTrack(piles, i+1, m, !isMineTurn);
            if (res < min) {
                min = res;
            }
            if (res + beforeSum > max) {
                max = res + beforeSum;
            }
        }

        int res = isMineTurn ? max : min;
        memoMap.put(key, res);
        return  res; // 我的回合取最大值，对方回合取最小值
    }

    public int stoneGameII(int[] piles) {
        return backTrack(piles, 0, 1, true);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1140().stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(new Problem1140().stoneGameII(new int[]{1,2,3,4,5,100}));
        System.out.println(new Problem1140().stoneGameII(new int[]{1,5,7,9,9}));
    }
    
}
