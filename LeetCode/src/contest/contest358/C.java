package contest.contest358;

import utils.TreeMultiSet;

import java.util.ArrayList;
import java.util.List;

public class C {

    private int findLastSmallerOrEqual(List<Integer> arr, int from, int target) {
        int len = arr.size();
        int low = from;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr.get(mid);
            if (midVal <= target) {
                if (mid == len - 1 || arr.get(mid + 1) > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findFirstBiggerOrEqual(List<Integer> arr, int from, int target) {
        int low = from;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr.get(mid);
            if (midVal >= target) {
                if (mid == from || arr.get(mid - 1) < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int len = nums.size();
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();
        for (int i = x; i < len; i++) {
            treeMultiSet.add(nums.get(i));
        }

        Integer firstBigger = treeMultiSet.ceiling(nums.get(0));
        Integer lastSmaller = treeMultiSet.floor(nums.get(0));
        if (firstBigger == null) {
            firstBigger = nums.get(len - 1);
        }

        if (lastSmaller == null) {
            lastSmaller = nums.get(x);
        }

        int ansMin = Math.min(Math.abs(firstBigger - nums.get(0)), Math.abs(lastSmaller - nums.get(0)));

        for (int i = 1; i < len - x; i++) {
            int j = i + x;
            treeMultiSet.remove(nums.get(i + x - 1));
            Integer firstBigger1 = treeMultiSet.ceiling(nums.get(i));
            Integer lastSmaller1 = treeMultiSet.floor(nums.get(i));
            if (firstBigger1 == null) {
                firstBigger1 = nums.get(len - 1);
            }

            if (lastSmaller1 == null) {
                lastSmaller1 = nums.get(j);
            }
            int tmpMin = Math.min(Math.abs(firstBigger1 - nums.get(i)), Math.abs(lastSmaller1 - nums.get(i)));
            ansMin = Math.min(ansMin, tmpMin);
        }

        return ansMin;
    }

}
