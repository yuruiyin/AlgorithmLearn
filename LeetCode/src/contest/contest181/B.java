package contest.contest181;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/22
 */
public class B {

    private int getAns(int n) {
        int end = (int) Math.sqrt(n);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= end; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
                if (set.size() > 4) {
                    return 0;
                }
            }
        }

        if (set.size() != 4) {
            return 0;
        }

        int ans = 0;
        for (Integer num :  set) {
            ans += num;
        }
        return ans;
    }

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += getAns(num);
        }
        return ans;
    }

}
