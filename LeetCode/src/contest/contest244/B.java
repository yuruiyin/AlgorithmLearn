package contest.contest244;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/6
 */
public class B {

    public int reductionOperations(int[] nums) {
        int[] countArr = new int[50001];
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            countArr[num]++;
            minNum = Math.min(minNum, num);
        }

        int ans = 0;
        int preCount = 0;
        for (int i = 50000; i >= 1; i--) {
            if (countArr[i] == 0) {
                continue;
            }

            if (i == minNum) {
                break;
            }

            countArr[i] += preCount;
            preCount = countArr[i];
            ans += countArr[i];
        }

        return ans;
    }

}
