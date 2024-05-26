package contest.contest375;

import java.util.ArrayList;
import java.util.List;

public class B {

    // 快速pow 二分
    private long pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % mod;
            }

            x = (x * x) % mod;
            n >>= 1;
        }
        return res % mod;
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
//        给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
//
//        如果满足以下公式，则下标 i 是 好下标：
//
//        0 <= i < variables.length
//                ((aibi % 10)ci) % mi == target
//        返回一个由 好下标 组成的数组，顺序不限 。
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            int a = variable[0];
            int b = variable[1];
            int c = variable[2];
            int m = variable[3];
            int value = (int) (pow(pow(a, b, 10), c, m));
            if (value == target) {
                ansList.add(i);
            }
        }
        return ansList;
    }

}
