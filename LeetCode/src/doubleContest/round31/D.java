package doubleContest.round31;

import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/25
 */
public class D {

    private int[] target;

    private int rec(int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return target[l];
        }

        if (l + 1 == r) {
            return Math.max(target[l], target[r]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            if (target[i] < min) {
                min = target[i];
            }
        }

        int ans = min;
        int curL = l;
        for (int i = l; i <= r; i++) {
            target[i] -= min;
            if (target[i] == 0) {
                ans += rec(curL, i - 1);
                curL = i + 1;
            }
        }

        if (target[r] != 0) {
            ans += rec(curL, r);
        }

        return ans;
    }

    public int minNumberOperations(int[] target) {
        this.target = target;
        return rec(0, target.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new D().minNumberOperations(new int[]{3, 1, 1, 2}));
    }

}
