package contest.contest288;

import java.util.Arrays;

public class D {

    private int findFirstSmallerIdx(int[] arr, int from, long target) {
        int l = from;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                l = mid + 1;
            } else {
                if (mid == from || arr[mid - 1] >= target) {
                    return mid;
                }
                r = mid - 1;
            }
        }

        return -1;
    }

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int len = flowers.length;
        for (int i = 0; i < len; i++) {
            if (flowers[i] > target) {
                flowers[i] = target;
            }
        }
        Arrays.sort(flowers);
        int l = 0;
        int r = len - 1;
        while (l < r) {
            // 倒序
            int t = flowers[l];
            flowers[l] = flowers[r];
            flowers[r] = t;
            l++;
            r--;
        }

        long[] preSumArr = new long[len];
        preSumArr[0] = flowers[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + flowers[i];
        }

        long[] sufSumArr = new long[len];
        sufSumArr[len - 1] = flowers[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + flowers[i];
        }

        long ansMax = 0;
        for (int i = -1; i < len; i++) {
            long preNeed = 0;
            long leftScore = 0;
            if (i >= 0) {
                preNeed = (long)target * (i + 1) - preSumArr[i];
                if (preNeed > newFlowers) {
                    break;
                }

                leftScore = (long)(i + 1) * full;
                if (i == len - 1) {
                    ansMax = Math.max(ansMax, leftScore);
                    break;
                }
            }

            // 右边剩下的可种植的花
            long leftFlowers = newFlowers - preNeed;
            // 二分
            long left = flowers[len - 1];
            long right = Math.min(target - 1, leftFlowers + left);
            long maxRightScore = 0;
            while (left <= right) {
                long mid = (left + right) >>> 1L;
                int firstSmallerIdx = findFirstSmallerIdx(flowers, i + 1, mid);
                if (firstSmallerIdx != -1) {
                    long rightNeed = mid * (len - firstSmallerIdx) - sufSumArr[firstSmallerIdx];
                    if (rightNeed <= leftFlowers) {
                        maxRightScore = Math.max(maxRightScore, mid * partial);
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    maxRightScore = Math.max(maxRightScore, (long)flowers[len - 1] * partial);
                    left = mid + 1;
                }
            }
            ansMax = Math.max(ansMax, leftScore + maxRightScore);
        }

        return ansMax;
    }

    public static void main(String[] args) {
        // flowers = [1,3,1,1], newFlowers = 7, target = 6, full = 12, partial = 1
        // [2,4,5,3], newFlowers = 10, target = 5, full = 2, partial = 6
        //[1,1]
        //2
        //2
        //1
        //2
        // [13]
        //18
        //15
        //9
        //2
//        System.out.println(new D().maximumBeauty(new int[]{1,3,1,1}, 7, 6, 12, 1));

//        System.out.println(new D().maximumBeauty(new int[]{2,4,5,3}, 10, 5, 2, 6));
//        System.out.println(new D().maximumBeauty(new int[]{1, 1}, 2, 2, 1, 2));
        System.out.println(new D().maximumBeauty(new int[]{13}, 18, 15, 9, 2));
        System.out.println("hello world");
    }

}
