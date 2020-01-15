package contest.contest112;

import java.util.*;

public class Problem945 {

    private int findFirstBigger(List<Integer> list, int from, int target) {
        int size = list.size();
        int low = from;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal > target) {
                if (mid == from || list.get(mid - 1) <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int minIncrementForUnique(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        List<Integer> notAppearList = new ArrayList<>();
        for (int i = 1; i <= 80000; i++) {
            if (!set.contains(i)) {
                notAppearList.add(i);
            }
        }

        int from = 0;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i-1]) {
                from = findFirstBigger(notAppearList, from, arr[i]);
                ans += notAppearList.get(from) - arr[i];
                from++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem945().minIncrementForUnique(new int[]{14,4,5,14,13,14,10,17,2,12,2,14,7,13,14,13,4,16,4,10}));
    }

}
