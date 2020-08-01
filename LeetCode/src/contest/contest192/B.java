package contest.contest192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/7
 */
public class B {

    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n - 1) / 2];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - m) > Math.abs(o2 - m) || (Math.abs(o1 - m) == Math.abs(o2 - m) && o1 > o2)) {
                    return -1;
                }

                return 1;
            }
        });

        int[] ansArr = new int[k];
        for (int i = 0; i < k; i++) {
            ansArr[i] = list.get(i);
        }
        return ansArr;
    }

}
