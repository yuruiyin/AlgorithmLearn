package problem701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem735
 *
 * @author: yry
 * @date: 2020/3/30
 */
public class Problem735 {

    public int[] asteroidCollision(int[] arr) {
        // 暴力
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= 0) {
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < 0) {
                    break;
                }

                if (arr[j] == 0) {
                    continue;
                }

                if (arr[j] > -arr[i]) {
                    arr[i] = 0;
                    break;
                } else if (arr[j] == -arr[i]) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                } else {
                    arr[j] = 0;

                }
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int value : arr) {
            if (value != 0) {
                ansList.add(value);
            }
        }

        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

}
