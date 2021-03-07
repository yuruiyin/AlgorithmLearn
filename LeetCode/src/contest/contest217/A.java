package contest.contest217;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/29
 */
public class A {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] arr : accounts) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}
