package doubleContest.round25;

import javax.print.attribute.standard.NumberUp;
import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/2
 */
public class D_1 {

    private static final int MOD = 1000000007;

    private int personCount;
    private long[] arr;
    private Long[][] memo;
    private List<Integer> hatList;
    private int hatCount;

    private long dp(int idx, int flag) {
        if (flag + 1 == (1 << personCount)) {
            return 1;
        }

        if (idx == hatCount) {
            return 0;
        }

        // 剩下的帽子的个数小于剩下的没带帽子的人的个数
        if (hatCount - idx < personCount - Integer.bitCount(flag)) {
            return 0;
        }

        if (memo[idx][flag] != null) {
            return memo[idx][flag];
        }

        int curHat = hatList.get(idx);

        long ans = dp(idx + 1, flag); // 当前帽子不分给任何一个人
        for (int i = 0; i < personCount; i++) {
            long loveHats = arr[i];
            if ((loveHats & (1L << curHat)) != 0 && (flag & (1 << i)) == 0) {
                ans = (ans + dp(idx + 1, flag | (1 << i))) % MOD;
            }
        }

        memo[idx][flag] = ans;
        return ans;
    }

    private long zip(List<Integer> list) {
        long ans = 0;
        for (Integer num : list) {
            ans |= 1L << num;
        }
        return ans;
    }

    public int numberWays(List<List<Integer>> hats) {
        this.personCount = hats.size();
        this.arr = new long[personCount];

        Set<Integer> hatSet = new HashSet<>();

        for (int i = 0; i < personCount; i++) {
            List<Integer> list = hats.get(i);
            // 压缩成long
            arr[i] = zip(list);
            hatSet.addAll(list);
        }

        hatList = new ArrayList<>(hatSet);
        hatCount = hatList.size();
        memo = new Long[41][1 << personCount];
        return (int) (dp(0, 0) % MOD);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            List<Integer> tmpList = new ArrayList<>();
//            for (int j = 1; j <= 40; j++) {
//                tmpList.add(j);
//            }
//            list.add(tmpList);
//        }
//
//        System.out.println(new D_1().numberWays(list));
//        int[][] arr = new int[][] {
//                {3,5,6,9,14,15,16,19,20,21,22,23,24,25},{1,2,3,6,8,9,10,11,16,21,22,23,24,25},{1,5,6,8,11,13,14,15,17,19,20,21,22,23,25},{1,2,3,4,5,7,10,11,14,17,19,20,21,23,24},{8,13},{2,3,4,5,6,8,9,10,12,13,14,16,19,20,23,25},{1,2,3,4,5,6,7,9,10,11,13,14,15,16,20,22,24},{1,3,4,5,6,8,10,11,15,16,17,19,22,25}
//        };
//        int[][] arr = new int[][] {
//                {3,4}, {4, 5}, {5}
//        };

        int[][] arr = new int[][] {
                {3,5,1}, {3, 5}
        };

        for (int i = 0; i < arr.length; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                tmpList.add(arr[i][j]);
            }
            list.add(tmpList);
        }

        System.out.println(new D_1().numberWays(list));
    }

}
