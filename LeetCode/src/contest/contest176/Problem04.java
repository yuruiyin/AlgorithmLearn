package contest.contest176;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem04 {

    private int findFirstBiggerOrEqual(List<Long> list, long target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target <= list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return list.size();
    }

    public boolean isPossible(int[] target) {
        int n = target.length;
        if (n == 1) {
            return target[0] == 1;
        }

        Arrays.sort(target);
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += target[i];
        }

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add((long) target[i]);
        }

        while (true) {
            long curMax = list.get(n - 1);
            if (curMax == 1) {
                return true;
            }
            if (sum - curMax >= curMax) {
                return false;
            }

            long newNum = curMax - (sum - curMax);
            list.remove(list.size() - 1);
            int insertIndex = findFirstBiggerOrEqual(list, newNum);
            list.add(insertIndex, newNum);
            sum = sum - curMax + newNum;
        }

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem04().isPossible(new int[]{9, 3, 5}));
    }

}
