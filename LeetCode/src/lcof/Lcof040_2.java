package lcof;

import java.util.Arrays;

/**
 * Lcof040_2
 * 桶排序的思路
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class Lcof040_2 {

    private final static int MAX = 10001;

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] countArr = new int[MAX];
        for (int num : arr) {
            countArr[num]++;
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = 0; i < MAX; i++) {
            if (index + countArr[i] <= k) {
                Arrays.fill(ans, index, index + countArr[i], i);
                index += countArr[i];
            } else {
                Arrays.fill(ans, index, k, i);
                break;
            }
        }

        return ans;
    }

}
