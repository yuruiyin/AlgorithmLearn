package contest.contest190;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/24
 */
public class D {

    private Integer[][] memo;
    private int[] arr1;
    private int[] arr2;
    private int len1;
    private int len2;
    private List<Integer> positiveIdxList2;
    private List<Integer> negativeIdxList2;

    private int findFirstBiggerOrEqual(List<Integer> list, int target) {
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

        return -1;
    }

    private int dp(int idx1, int idx2) {
        if (idx1 == len1 || idx2 == len2) {
            return 0;
        }

        if (memo[idx1][idx2] != null) {
            return memo[idx1][idx2];
        }

        int nonChooseRes = dp(idx1 + 1, idx2);
        int num1 = arr1[idx1];
        int chooseRes = Integer.MIN_VALUE;
        if (num1 > 0) {
            int firstBiggerEqualIdx = findFirstBiggerOrEqual(positiveIdxList2, idx2);
            if (firstBiggerEqualIdx != -1) {
                int size = positiveIdxList2.size();
                for (int i = firstBiggerEqualIdx; i < size; i++) {
                    int tmpIdx2 = positiveIdxList2.get(i);
                    chooseRes = Math.max(chooseRes, dp(idx1 + 1, tmpIdx2 + 1) + arr1[idx1] * arr2[tmpIdx2]);
                }
            }
        } else if (num1 < 0) {
            int firstBiggerEqualIdx = findFirstBiggerOrEqual(negativeIdxList2, idx2);
            if (firstBiggerEqualIdx != -1) {
                int size = negativeIdxList2.size();
                for (int i = firstBiggerEqualIdx; i < size; i++) {
                    int tmpIdx2 = negativeIdxList2.get(i);
                    chooseRes = Math.max(chooseRes, dp(idx1 + 1, tmpIdx2 + 1) + arr1[idx1] * arr2[tmpIdx2]);
                }
            }
        }

        memo[idx1][idx2] = Math.max(nonChooseRes, chooseRes);
        return memo[idx1][idx2];
    }

    private void calc(int[] arr, List<Integer> positiveIdxList, List<Integer> negativeIdxList) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveIdxList.add(i);
            } else if (arr[i] < 0) {
                negativeIdxList.add(i);
            }
        }
    }

    private void calcIdxList() {
        positiveIdxList2 = new ArrayList<>();
        negativeIdxList2 = new ArrayList<>();
        calc(arr2, positiveIdxList2, negativeIdxList2);
    }

    private boolean hasZero(int[] arr) {
        for (int num : arr) {
            if (num == 0) {
                return true;
            }
        }
        return false;
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        // 正数与正数，负数与负数相乘
        arr1 = nums1;
        arr2 = nums2;
        this.len1 = arr1.length;
        this.len2 = arr2.length;

        memo = new Integer[len1][len2];
        calcIdxList();
        int res = dp(0, 0);
        if (res == 0) {
            //如果结果==0，有可能一个都没选
            if (hasZero(arr1) || hasZero(arr2)) {
                return 0;
            }

            int maxRes = Integer.MIN_VALUE;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    maxRes = Math.max(maxRes, arr1[i] * arr2[j]);
                }
            }

            return maxRes;
        } else {
            return res;
        }
    }

}
