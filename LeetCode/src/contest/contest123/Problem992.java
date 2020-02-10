package contest.contest123;

import java.util.HashMap;
import java.util.Map;

// TODO 还未通过
public class Problem992 {

    public int subarraysWithKDistinct(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = arr.length;
        int ans = 0;
        int right = k - 1;

        for (int left = 0; right < len; left++) {
            int curCount = 0;
            if (countMap.isEmpty()) {
                for (int i = left; i <= right; i++) {
                    countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
                }
            }

            int diffCount = countMap.keySet().size();
            if (diffCount == k) {
                curCount++;
            }

            int i;
            for (i = right + 1; i < len; i++) {
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
                int tmpDiffCount = countMap.keySet().size();
                if (tmpDiffCount > k) {
                    countMap.remove(arr[i]);
                    break;
                }

                if (tmpDiffCount == k) {
                    curCount++;
                }
            }

            ans += curCount;
            int leftCount = countMap.get(arr[left]);
            if (leftCount == 1) {
                countMap.remove(arr[left]);
                right = i;
                if (right < len) {
                    countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);
                }
            } else {
                countMap.put(arr[left], leftCount - 1);
                for (int j = i - 1; j > left + k; j--) {
                    int count = countMap.get(arr[j]);
                    if (count == 1) {
                        countMap.remove(arr[j]);
                    } else {
                        countMap.put(arr[j], count - 1);
                    }
                }
                right = left + k;
            }

        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem992().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
//        System.out.println(new Problem992().subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
//        System.out.println(new Problem992().subarraysWithKDistinct(new int[]{2,1,1,1,2}, 1));
    }

}
