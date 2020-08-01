package doubleContest.round31;

/**
 * D_1
 *
 * @author: yry
 * @date: 2020/7/26
 */
public class D_1 {

    public int minNumberOperations(int[] target) {
        int len = target.length;
        int ans = target[0];
        for (int i = 1; i < len; i++) {
            if (target[i] > target[i - 1]) {
                ans += target[i] - target[i-1];
            }
        }
        return ans;
    }

}
