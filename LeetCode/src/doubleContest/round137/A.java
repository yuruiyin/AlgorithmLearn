package doubleContest.round137;

import utils.TreeMultiSet;

import java.util.Arrays;
import java.util.LinkedList;

public class A {

    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int len = nums.length;
        int[] ansArr = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(nums[k - 1]);
        Arrays.fill(ansArr, -1);
        for (int i = k - 2; i >= 0; i--) {
            if (nums[i + 1] - nums[i] != 1) {
                break;
            }
            queue.addFirst(nums[i]);
        }

        if (queue.size() == k) {
            ansArr[0] = queue.getLast();
            queue.removeFirst();
        }
        int j = 1;
        for (int i = k; i < len; i++) {
            if (queue.getLast() != nums[i] - 1) {
                queue.clear();
                queue.add(nums[i]);
            } else {
                queue.addLast(nums[i]);
                if (queue.size() == k) {
                    ansArr[j] = nums[i];
                    queue.removeFirst();
                }
            }
            j++;
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
