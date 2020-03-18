package problem701_800;

/**
 * Problem754
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class Problem754 {

    public int reachNumber(int target) {
        // 只要sum比target大，且(sum - target)是偶数即可
        int sum = 0;
        int i = 1;
        target = Math.abs(target);
        while (sum < target || (sum - target) % 2 != 0) {
            sum += i;
            i++;
        }

        return i - 1;
    }

}
