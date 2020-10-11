package dianfeng_contest.S110;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/8
 */
public class A {

    /**
     * 返回牛牛最终是从第几个门进入食堂吃饭的
     * @param n int整型 代表门的数量
     * @param a int整型一维数组 代表每个门外等待的人数
     * @return int整型
     */
    public int solve (int n, int[] a) {
        // write code here
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i] / n);
        }

        for (int i = 0; i < n; i++) {
            if (a[i] / n == min && a[i] % n <= i) {
                return i + 1;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new A().solve(3, new int[]{5, 6, 7}));
        System.out.println(new A().solve(4, new int[]{2, 3, 2, 0}));
        System.out.println(new A().solve(3, new int[]{2, 10, 10}));
    }

}
