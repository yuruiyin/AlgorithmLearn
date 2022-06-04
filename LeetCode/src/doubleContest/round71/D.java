package doubleContest.round71;

import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

    public long minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len / 3;
        // 左边留最小n个数，右边留最大n个数
        long leftMinSum = 0;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        long rightMaxSum = 0;
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < n; i++) {
            leftMinSum += nums[i];
            leftHeap.add(nums[i]);
        }
        for (int i = 2 * n; i < len; i++) {
            rightMaxSum += nums[i];
            rightHeap.add(nums[i]);
        }

        long[] rightMaxSumArr = new long[len];
        rightMaxSumArr[2 * n] = rightMaxSum;
        for (int i = 2 * n - 1; i >= n; i--) {
            if (nums[i] > rightHeap.peek()) {
                int top = rightHeap.poll();
                rightHeap.add(nums[i]);
                rightMaxSumArr[i] = rightMaxSumArr[i + 1] - top + nums[i];
            } else {
                rightMaxSumArr[i] = rightMaxSumArr[i + 1];
            }
        }

        long ansMin = leftMinSum - rightMaxSumArr[n];
        for (int i = n; i < 2 * n; i++) {
            if (nums[i] < leftHeap.peek()) {
                int top = leftHeap.poll();
                leftHeap.add(nums[i]);
                leftMinSum = leftMinSum - top + nums[i];
            }
            ansMin = Math.min(ansMin, leftMinSum - rightMaxSumArr[i + 1]);
        }
        return ansMin;
    }

    public static void main(String[] args) {
        // [16,46,43,41,42,14,36,49,50,28,38,25,17,5,18,11,14,21,23,39,23]
//        System.out.println(new D().minimumDifference(new int[]{7,9,5,8,1,3}));
        System.out.println(new D().minimumDifference(new int[]{16,46,43,41,42,14,36,49,50,28,38,25,17,5,18,11,14,21,23,39,23}));
    }

}
