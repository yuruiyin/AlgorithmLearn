package doubleContest.round42;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/26
 */
public class D {

    public int minMoves(int[] nums, int k) {
        int len = nums.length;

        //先求所有1的索引
        List<Integer> oneIdxList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                oneIdxList.add(i);
            }
        }

        int size = oneIdxList.size();

        int[] preSumArr = new int[size];
        preSumArr[0] = oneIdxList.get(0);
        for (int i = 1; i < size; i++) {
            preSumArr[i] = preSumArr[i - 1] +  oneIdxList.get(i);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = (k - 1) / 2; i < size - (k - 1) / 2; i++) {
            if (i + k - (k - 1) / 2 - 1 >= size) {
                break;
            }
            int value = preSumArr[i] - preSumArr[i - (k - 1) / 2] - (k - 1) / 2 +
                    preSumArr[i + k - (k - 1) / 2 - 1] - preSumArr[i] - (k - (k - 1) / 2 - 1);
            ansMin = Math.min(ansMin, value);
        }

        return ansMin;
    }

}
