package pre01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * B
 *
 * @author: yry
 * @date: 2020/8/29
 */
public class B {

    /**
     * @param arr: the lengths of sticks at the beginning.
     * @return: return the minimum number of cuts.
     */
    public int makeEquilateralTriangle(int[] arr) {
        // write your code here.
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;

        for (Integer len : countMap.keySet()) {
            maxCount = Math.max(maxCount, countMap.get(len));
        }

        if (maxCount >= 3) {
            return 0;
        }

        if (maxCount == 2) {
            int index = -1;
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    index = i;
                    break;
                }
            }

            if (index != n - 1) {
                return 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int target = 2 * arr[i];
            int index = Arrays.binarySearch(arr, target);
            if (index >= 0) {
                return 1;
            }
        }

        return 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().makeEquilateralTriangle(new int[]{2, 3, 5, 7}));
        System.out.println(new B().makeEquilateralTriangle(new int[]{2, 3, 4, 7}));
        System.out.println(new B().makeEquilateralTriangle(new int[]{2, 2, 2, 7}));
        System.out.println(new B().makeEquilateralTriangle(new int[]{1, 3, 4, 4}));
    }

}
