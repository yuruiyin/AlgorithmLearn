package doubleContest.round143;

import java.util.TreeMap;

public class B {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        int len1 = treeMap.size();
        int[] nums1 = new int[len1];
        int idx = 0;
        int maxCount = 1;
        for (int num : treeMap.keySet()) {
            nums1[idx++] = num;
            maxCount = Math.max(maxCount, treeMap.get(num));
        }

        if (k == 0) {
            return maxCount;
        }

        int[] rightCountArr = new int[len1];
        rightCountArr[len1 - 1] = treeMap.get(nums1[len1 - 1]);
        for (int i = len1 - 2; i >= 0; i--) {
            rightCountArr[i] = rightCountArr[i + 1] + treeMap.get(nums1[i]);
        }

        int[] leftCountArr = new int[len1];
        leftCountArr[0] = treeMap.get(nums1[0]);
        for (int i = 1; i < len1; i++) {
            leftCountArr[i] = leftCountArr[i - 1] + treeMap.get(nums1[i]);
        }

        int[] rightMaxCountArr = new int[len1];

        int leftIdx = 0;
        int ansCount = treeMap.get(nums1[0]);
        int curCount = ansCount;
        int leftOperation = numOperations;
        rightMaxCountArr[0] = curCount;
        for (int i = 1; i < len1 && leftIdx < len1;) {
            int num = nums1[i];
            while (num - k * leftOperation > nums1[leftIdx] && leftIdx < i) {
                leftIdx++;
                leftOperation = numOperations;
                curCount = treeMap.get(nums1[leftIdx]);
                rightMaxCountArr[leftIdx] = curCount;
//                ansCount = Math.max(ansCount, curCount);
            }

            // num - k <= nums1[leftIdx]
            if (leftIdx == i || leftOperation == 0) {
                if (i < len1 - 1) {
                    i++;
                } else {
                    leftIdx++;
                }
                continue;
            }

            int eachCount = (num - nums1[leftIdx]) / k + ((num - nums1[leftIdx]) % k != 0 ? 1 : 0);

            // leftIdx < i
            int tmpCount = treeMap.get(nums1[i]);
            if (tmpCount * eachCount <= leftOperation) {
                curCount += tmpCount;
                leftOperation -= tmpCount * eachCount;
            } else {
                curCount += leftOperation / eachCount;
                leftOperation = 0;
            }
            rightMaxCountArr[leftIdx] = curCount;
            if (i < len1 - 1) {
                i++;
            } else {
                leftIdx++;
            }
//            ansCount = Math.max(ansCount, curCount);
        }

//        for (int i = leftIdx + 1; i < len1; i++) {
//            if (i == len1 - 1) {
//                rightMaxCountArr[i] = treeMap.get(nums1[i]);
//            } else {
//                rightMaxCountArr[i] = treeMap.get(nums1[i]) + Math.min(numOperations, rightCountArr[i + 1]);
//            }
//        }

        // 逆过来来一次

        int[] leftMaxCountArr = new int[len1];

        int rightIdx = len1 - 1;
        int curCount1 = treeMap.get(nums1[rightIdx]);
        int leftOperation1 = numOperations;
        leftMaxCountArr[rightIdx] = curCount1;
        for (int i = len1 - 2; i >= 0 && rightIdx >= 0;) {
            int num = nums1[i];
            while (num + k * leftOperation1 < nums1[rightIdx] && rightIdx > i) {
                rightIdx--;
                leftOperation1 = numOperations;
                curCount1 = treeMap.get(nums1[rightIdx]);
                leftMaxCountArr[rightIdx] = curCount1;
//                ansCount = Math.max(ansCount, curCount1);
            }

            // num - k <= nums1[leftIdx]
            if (rightIdx == i || leftOperation1 == 0) {
                if (i > 0) {
                    i--;
                } else {
                    rightIdx--;
                }
                continue;
            }

            int eachCount = (nums1[rightIdx] - num) / k + ((nums1[rightIdx] - num) % k != 0 ? 1 : 0);

            // leftIdx < i
            int tmpCount = treeMap.get(nums1[i]);
            if (tmpCount * eachCount <= leftOperation1) {
                curCount1 += tmpCount;
                leftOperation1 -= tmpCount * eachCount;
            } else {
                curCount1 += leftOperation1 / eachCount;
                leftOperation1 = 0;
            }
            leftMaxCountArr[rightIdx] = curCount1;
            if (i > 0) {
                i--;
            } else {
                rightIdx--;
            }
//            ansCount = Math.max(ansCount, curCount1);
        }

//        for (int i = rightIdx - 1; i >= 0; i--) {
//            if (i == 0) {
//                leftMaxCountArr[i] = treeMap.get(nums1[i]);
//            } else {
//                leftMaxCountArr[i] = treeMap.get(nums1[i]) + Math.min(numOperations, leftCountArr[i - 1]);
//            }
//        }

        for (int i = 0; i < len1; i++) {
            ansCount = Math.max(ansCount, treeMap.get(nums1[i]) + Math.min(numOperations, leftMaxCountArr[i] + rightMaxCountArr[i] - 2 * treeMap.get(nums1[i])));
        }

        return ansCount;
    }

    public static void main(String[] args) {
//        System.out.println(new B().maxFrequency(new int[]{88, 53}, 27, 2));
        System.out.println(new B().maxFrequency(new int[]{2,70,73}, 39, 2));
    }

}
