package problem301_400;

import utils.PrintUtil;

/**
 * Problem321_1
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class Problem321_1 {

    // 计算右边（包括自己）最大的元素的索引
    private int[] getRightMaxIdxArr(int[] nums) {
        int len = nums.length;
        int[] rightMaxIdxArr = new int[len];
        int rightMax = 0;
        int rightMaxIdx = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] >= rightMax) { // 最大出现大于1个，选最左侧那个
                rightMax = nums[i];
                rightMaxIdx = i;
            }
            rightMaxIdxArr[i] = rightMaxIdx;
        }
        return rightMaxIdxArr;
    }

    // 求单个数组的长度为k的最大子序列
    private int[] getMax(int[] nums, int k, int[] rightMaxIdxArr) {
        int[] ansArr = new int[k];
        int size = 0;
        for (int i = 0; i < nums.length;) {
            if (k == size) {
                return ansArr;
            }

            if (nums.length - i == k - size) {
                for (int j = i; j < nums.length; j++) {
                    ansArr[size++] = nums[j];
                }
                return ansArr;
            }

            int rightMaxIdx = rightMaxIdxArr[i];
            if (k - size <= nums.length - rightMaxIdx) {
                // 选现在右侧最大的可以满足
                ansArr[size++] = nums[rightMaxIdx];
                i = rightMaxIdx + 1;
            } else {
                // 选现在右侧最大的会导致剩下的元素不够
                int end = nums.length - (k - size);
                int max = -1;
                int maxIdx = -1;
                for (int j = i; j <= end; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIdx = j;
                    }
                }

                ansArr[size++] = nums[maxIdx];
                i = maxIdx + 1;
            }
        }

        return ansArr;
    }

    // 合并两个最大子序列，贪心
    private int[] merge(int[] max1, int[] max2) {
        int len = max1.length + max2.length;
        int[] ans = new int[len];
        int size = 0;
        int i, j;
        for (i = 0, j = 0; i < max1.length && j < max2.length;) {
            if (max1[i] > max2[j]) {
                ans[size++] = max1[i];
                i++;
            } else if (max1[i] < max2[j]) {
                ans[size++] = max2[j];
                j++;
            } else {
                // 相等, 看后面的字典序谁大
                if (isBigger(max1, i, max2, j)) {
                    ans[size++] = max1[i];
                    i++;
                } else {
                    ans[size++] = max2[j];
                    j++;
                }
            }
        }

        while (i < max1.length) {
            ans[size++] = max1[i++];
        }

        while (j < max2.length) {
            ans[size++] = max2[j++];
        }

        return ans;
    }

    private boolean isBigger(int[] nums1, int from1, int[] nums2, int from2) {
        int i, j;
        for (i = from1, j = from2; i < nums1.length && j < nums2.length; i++, j++) {
            if (nums1[i] > nums2[j]) {
                return true;
            } else if (nums1[i] < nums2[j]) {
                return false;
            }
        }

        return i < nums1.length;
    }

    private boolean isBigger(int[] nums1, int[] nums2) {
        int len = nums1.length;
        for (int i = 0; i < len; i++) {
            if (nums1[i] > nums2[i]) {
                return true;
            } else if (nums1[i] < nums2[i]) {
                return false;
            }
        }
        return false;
    }

    /**
     * 思路：最终生成的最大子序列一定包含nums1数组的长度为i(i可能为0)的最大子序列，以及nums2数组的长度为k-i的最大子序列
     * 因此，我们遍历i，然后求得各自对应长度的最大子序列，然后求得合并后的最大序列。
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int min = Math.min(nums1.length, k);
        int[] ansMaxArr = new int[k];
        int[] rightMaxIdxArr1 = getRightMaxIdxArr(nums1);
        int[] rightMaxIdxArr2 = getRightMaxIdxArr(nums2);
        for (int i = 0; i <= min; i++) {
            if (k - i > nums2.length || k - i < 0) {
                continue;
            }

            int[] mergeArr;
            if (i == 0) {
                mergeArr = getMax(nums2, k - i, rightMaxIdxArr2);
            } else if (k - i == 0) {
                mergeArr = getMax(nums1, i, rightMaxIdxArr1);
            } else {
                mergeArr = merge(getMax(nums1, i, rightMaxIdxArr1), getMax(nums2, k - i, rightMaxIdxArr2));
            }

            if (isBigger(mergeArr, ansMaxArr)) {
                ansMaxArr = mergeArr;
            }
        }

        return ansMaxArr;
    }

    public static void main(String[] args) {
//        int[] ans = new Problem321().maxNumber(new int[]{6, 7}, new int[]{6, 0}, 4);
        int[] ans = new Problem321().maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,6,2}, 15);
        PrintUtil.printIntArray(ans);
    }

}
