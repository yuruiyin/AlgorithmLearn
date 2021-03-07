package contest.contest222;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/3
 */
public class A {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int ans = 0;
        int count = 0;
        for (int[] box : boxTypes) {
            if (count == truckSize) {
                break;
            }

            int left = truckSize - count;
            int tmp = Math.min(box[0], left);
            count += tmp;
            ans += tmp * box[1];
        }

        return ans;
    }

}
