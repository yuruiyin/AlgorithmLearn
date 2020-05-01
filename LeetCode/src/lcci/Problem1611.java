package lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem1611
 *
 * @author: yry
 * @date: 2020/4/14
 */
public class Problem1611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            int sum = shorter * i + longer * (k - i);
            set.add(sum);
        }

        int size = set.size();
        int[] ansArr = new int[size];
        int index = 0;
        for (Integer num : set) {
            ansArr[index++] = num;
        }

        Arrays.sort(ansArr);
        return ansArr;
    }

}
