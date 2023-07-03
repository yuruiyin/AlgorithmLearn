package contest.contest338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    private int findFirstBiggerOrEqual(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        List<Long> ansList = new ArrayList<>();
        for (int q : queries) {
            int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(nums, q);
            if (firstBiggerOrEqualIdx == -1) {
                ansList.add((long)q * len - preSumArr[len - 1]);
            } else {
                if (firstBiggerOrEqualIdx == 0) {
                    ansList.add(preSumArr[len - 1] - (long)q * len);
                } else {
                    ansList.add((long)q * firstBiggerOrEqualIdx - preSumArr[firstBiggerOrEqualIdx - 1] +
                            preSumArr[len - 1] - preSumArr[firstBiggerOrEqualIdx - 1] - (long)q * (len - firstBiggerOrEqualIdx));
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        String name = "1";
        System.out.println(name.equals("1"));
    }

}
