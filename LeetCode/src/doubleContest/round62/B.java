package doubleContest.round62;

import java.math.BigInteger;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/2
 */
public class B {

    public int numOfPairs(String[] nums, String target) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if ((nums[i] + nums[j]).equals(target)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }

}
