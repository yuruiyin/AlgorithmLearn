package doubleContest.round25;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/2
 */
public class D {

    private static final int MOD = 1000000007;

    private Map<Long, Long> memoMap;
    private int len;
    private int[][] arr;

    private long dp(int idx, long flag) {
        if (idx == len) {
            return 1;
        }

        long key = flag * len + idx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int[] list = arr[idx];
        long ans = 0;
        for (Integer hat : list) {
            if ((flag & (1L << hat)) != 0) {
                continue;
            }

            ans = (ans + dp(idx + 1, flag | (1L << hat))) % MOD;
        }

        memoMap.put(key, ans);
        return ans;
    }

    public int numberWays(List<List<Integer>> hats) {
        this.len = hats.size();
        this.arr = new int[len][];
        memoMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            List<Integer> list = hats.get(i);
            arr[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr[i][j] = list.get(j);
            }
        }

        return (int) (dp(0, 0) % MOD);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 1; j <= 40; j++) {
                tmpList.add(j);
            }
            list.add(tmpList);
        }

        System.out.println(new D().numberWays(list));
//        int[][] arr = new int[][] {
//                {3,5,6,9,14,15,16,19,20,21,22,23,24,25},{1,2,3,6,8,9,10,11,16,21,22,23,24,25},{1,5,6,8,11,13,14,15,17,19,20,21,22,23,25},{1,2,3,4,5,7,10,11,14,17,19,20,21,23,24},{8,13},{2,3,4,5,6,8,9,10,12,13,14,16,19,20,23,25},{1,2,3,4,5,6,7,9,10,11,13,14,15,16,20,22,24},{1,3,4,5,6,8,10,11,15,16,17,19,22,25}
//        };
//
//        for (int i = 0; i < arr.length; i++) {
//            List<Integer> tmpList = new ArrayList<>();
//            for (int j = 0; j < arr[i].length; j++) {
//                tmpList.add(arr[i][j]);
//            }
//            list.add(tmpList);
//        }
//
//        System.out.println(new D().numberWays(list));
    }

}
