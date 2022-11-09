package problem1701_1800;

import java.util.LinkedList;

public class Problem1703 {

    public int minMoves(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int len = nums.length;
        long idxSum = 0;
        long ansMin = Integer.MAX_VALUE;
        // 从左往右
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }

            idxSum += i;
            linkedList.addLast(i);
            if (linkedList.size() == k) {
                long s = i - k + 1;
                long e = i;
                long sum = (s + e) * k / 2;
                ansMin = Math.min(ansMin, sum - idxSum);
                int first = linkedList.pollFirst();
                idxSum -= first;
            }
        }

        // 从右往左
        linkedList = new LinkedList<>();
        idxSum = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                continue;
            }

            idxSum += i;
            linkedList.addLast(i);
            if (linkedList.size() == k) {
                long s = i;
                long e = i + k - 1;
                long sum = (s + e) * k / 2;
                ansMin = Math.min(ansMin, idxSum - sum);
                int first = linkedList.pollFirst();
                idxSum -= first;
            }
        }

        return (int) ansMin;
    }

}
