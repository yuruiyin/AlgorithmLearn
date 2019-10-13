package problem1201_1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        if (n == 1) {
            return 1;
        }

        // 存放每个数字的位置集合
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (!map.containsKey(key)) {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(key, indexList);
            } else {
                map.get(key).add(i);
            }
        }

        // 存放当前坐标往前最长的等差子序列的长度
        int[] max = new int[n];

        for (int i = 0; i < n; i++) {
            max[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int leftValue = arr[i] - difference;

            if (!map.containsKey(leftValue)) {
                continue;
            }

            int indexListSize = map.get(leftValue).size();
            int maxValue = 0;
            for (int j = 0; j < indexListSize; j++) {
                int index = map.get(leftValue).get(j);
                if (index >= i) {
                    break;
                }

                if (max[index] > maxValue) {
                    maxValue = max[index];
                }
            }

            max[i] = maxValue + 1;
        }

        int ansMax = 1;
        for (int i = 0; i < n; i++) {
            if (max[i] > ansMax) {
                ansMax = max[i];
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1218().longestSubsequence(new int[]{1,2,3,4}, 1));
        System.out.println(new Problem1218().longestSubsequence(new int[]{1,3,5,7}, 1));
        System.out.println(new Problem1218().longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
        System.out.println(new Problem1218().longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));

    }

}
