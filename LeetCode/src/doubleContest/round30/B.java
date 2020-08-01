package doubleContest.round30;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] countArr = new int[100005];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                countArr[sum]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100004; i++) {
            int count = countArr[i];
            while ((count--) > 0) {
                list.add(i);
            }
        }

        long ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + list.get(i)) % MOD;
        }

        return (int) ans;
    }

}
