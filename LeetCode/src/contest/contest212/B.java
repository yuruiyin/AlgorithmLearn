package contest.contest212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/25
 */
public class B {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] lArr, int[] rArr) {
        int m = lArr.length;
        List<Boolean> ansList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int l = lArr[i];
            int r = rArr[i];
            List<Integer> list = new ArrayList<>();
            for (int j = l; j <= r; j++) {
                list.add(nums[j]);
            }

            Collections.sort(list);
            int d = list.get(1) - list.get(0);
            boolean isOk = true;
            for (int j = 2; j < list.size(); j++) {
                int tmpD = list.get(j) - list.get(j-1);
                if (tmpD != d) {
                    isOk = false;
                    break;
                }
            }

            ansList.add(isOk);
        }

        return ansList;
    }

}
