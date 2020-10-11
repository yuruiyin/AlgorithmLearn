package contest.contest203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/23
 */
public class C {

    public int findLatestStep(int[] arr, int m) {
        // 倒过来，从全1开始
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, n - 1});
        for (int i = n - 1; i >= 0; i--) {
            int index = arr[i] - 1;
            List<int[]> newList = new ArrayList<>();
            for (int[] interval : list) {
                int dis = interval[1] - interval[0] + 1;
                if (dis == m) {
                    return i + 1;
                }

                if (dis < m) {
                    continue;
                }

                if (index >= interval[0] && index <= interval[1]) {
                    if (index == interval[0]) {
                        if (interval[1] - interval[0] >= m) {
                            newList.add(new int[] {interval[0] + 1, interval[1]});
                        }
                    } else if (index == interval[1]) {
                        if (interval[1] - interval[0] >= m) {
                            newList.add(new int[] {interval[0], interval[1] - 1});
                        }
                    } else {
                        if (index - interval[0] >= m) {
                            newList.add(new int[]{interval[0], index - 1});
                        }

                        if (interval[1] - index >= m) {
                            newList.add(new int[]{index + 1, interval[1]});
                        }
                    }
                } else {
                    newList.add(interval);
                }
            }

            if (newList.isEmpty()) {
                return -1;
            }

            list = newList;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new C().findLatestStep(new int[]{77,59,78,15,96,54,22,57,49,27,8,95,32,83,68,31,60,51,11,66,13,94,91,81,17,72,4,71,42,33,10,90,73,67,38,40,39,36,63,58,3,76,50,23,55,37,70,85,80,2,86,84,41,35,34,25,69,53,74,5,75,89,93,62,47,44,24,9,29,28,48,46,82,56,21,43,64,6,79,19,65,16,30,92,45,87,14,18,52,61,88,26,7,12,20,1}, 7));
    }

}
