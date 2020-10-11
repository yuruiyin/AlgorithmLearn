package dianfeng_contest.S108;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/1
 */
public class A {

    /**
     * 返回重新分配后，满足牛牛要求的水量的瓶子最多的数量
     * @param n int整型 瓶子的数量
     * @param x int整型 牛牛的对瓶中的水量要求
     * @param a int整型一维数组 每个瓶子中的含水量
     * @return int整型
     */
    public int solve (int n, int x, int[] a) {
        // write code here
        Arrays.sort(a);

        long sum = 0;
        long xx = x;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += a[i];
            if (sum < (n - i) * xx) {
                break;
            }
            count++;
        }

        return count;
    }

}
