package fall_2020;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/12
 */
public class C {

    public int minimumOperations(String leaves) {
        char[] arr = leaves.toCharArray();
        int n = arr.length;

        // 假设最后的y的区间为[l, r], 前缀r的个数pre, 则可得移动次数包括三部分组成
        // ans = (l - pre[l - 1]) + (pre[r] - pre[l - 1]) + (n - 1 - r - (pre[n - 1] + pre[r]))
        // 化简得：ans = n - 1 - pre[n-1] + (l - 2 * pre[l - 1]) + (2 * pre[r] - r)
        // 也就是在固定r的之后求l - 2 * pre[l - 1]的最小值
        int[] pre = new int[n];
        pre[0] = arr[0] == 'r' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 'r') {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = pre[i - 1];
            }
        }

        int[] minArr = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            min = Math.min(min, i - 2 * pre[i - 1]);
            minArr[i] = min;
        }

        int ans = Integer.MAX_VALUE;
        for (int r = 2; r < n - 1; r++) {
            ans = Math.min(ans, n - 1 - pre[n - 1] + minArr[r - 1] + 2 * pre[r] - r);
        }

        for (int i = 1; i < n - 1; i++) {
            int count = arr[i] == 'r' ? 1 : 0;
            ans = Math.min(ans, count + i - pre[i - 1] + n - 1 - i - pre[n - 1] + pre[i]);
        }

        return ans;
    }
    
    public static void main(String[] args) {
//        System.out.println(new C().minimumOperations("yyrrryryr")); // 3
//        System.out.println(new C().minimumOperations("ryyrrryrrr")); // 1
//        System.out.println(new C().minimumOperations("ryyrryrryryr")); // 3
//        System.out.println(new C().minimumOperations("ryrrryrryyyr")); // 2
//        System.out.println(new C().minimumOperations("ryrrryrrrrryr"));
//        System.out.println(new C().minimumOperations("ryyyrryrrryyr"));
//        System.out.println(new C().minimumOperations("yyy"));
//        System.out.println(new C().minimumOperations("rrr"));
        System.out.println(new C().minimumOperations("ryr"));
//        System.out.println(new C().minimumOperations("yrryrry"));
//        System.out.println(new C().minimumOperations("yryrrryyrry"));
        System.out.println(new C().minimumOperations("rrryyyyry"));
    }

}
