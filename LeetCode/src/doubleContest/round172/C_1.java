package doubleContest.round172;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C_1 {

    public long maximumScore(int[] nums, String s) {
        int len = nums.length;
        char[] arr = s.toCharArray();
        long sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < len; i++) {
            heap.add(nums[i]);
            if (arr[i] == '1') {
                sum += heap.poll();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
