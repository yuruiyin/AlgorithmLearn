package contest.contest233;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/21
 */
public class D {

    private int findLastSmaller(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal < target) {
                if (mid == len - 1 || arr[mid + 1] >= target) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findLastSmallerOrEqual(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal <= target) {
                if (mid == len - 1 || arr[mid + 1] > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int countPairs(int[] nums, int low, int high) {
        int len = nums.length;
        Arrays.sort(nums);
        int lowCount = 0;
        for (int i = 0; i < len - 1; i++) {
            int bitCount = Integer.toBinaryString(nums[i]).length();
            if (nums[i] >= low) {
                // 只能与相同二进制位数的数异或
                for (int j = i + 1; j < len; j++) {
                    int bitCount1 = Integer.toBinaryString(nums[j]).length();
                    if (bitCount1 > bitCount) {
                        break;
                    }

                    if ((nums[j] ^ nums[i]) < low) {
                        lowCount++;
                    }
                }
            } else {
                int target = low - nums[i];
                int lastSmallerIdx = findLastSmaller(nums, target);
                int fromJ = i + 1;
                if (lastSmallerIdx > i) {
                    lowCount += lastSmallerIdx - i;
                    fromJ = lastSmallerIdx + 1;
                }

                for (int j = fromJ; j < len; j++) {
                    int bitCount1 = Integer.toBinaryString(nums[j]).length();
                    if (bitCount1 > bitCount && (1 << (bitCount1 - 1)) >= low) {
                        break;
                    }

                    if ((nums[j] ^ nums[i]) < low) {
                        lowCount++;
                    }
                }
            }
        }

        int highCount = 0;
        for (int i = 0; i < len - 1; i++) {
            int bitCount = Integer.toBinaryString(nums[i]).length();
            if (nums[i] > high) {
                // 只能与相同二进制位数的数异或
                for (int j = i + 1; j < len; j++) {
                    int bitCount1 = Integer.toBinaryString(nums[j]).length();
                    if (bitCount1 > bitCount) {
                        break;
                    }

                    if ((nums[j] ^ nums[i]) <= high) {
                        highCount++;
                    }
                }
            } else {
                int target = high - nums[i];
                int lastSmallerIdx = findLastSmallerOrEqual(nums, target);
                int fromJ = i + 1;
                if (lastSmallerIdx > i) {
                    highCount += lastSmallerIdx - i;
                    fromJ = lastSmallerIdx + 1;
                }

                for (int j = fromJ; j < len; j++) {
                    int bitCount1 = Integer.toBinaryString(nums[j]).length();
                    if (bitCount1 > bitCount && (1 << (bitCount1 - 1)) > high) {
                        break;
                    }

                    if ((nums[j] ^ nums[i]) <= high) {
                        highCount++;
                    }
                }
            }
        }

        return highCount - lowCount;
    }

    public static void main(String[] args) {
        System.out.println(new D().countPairs(new int[]{1, 4, 2, 7}, 2, 6));
    }

}
