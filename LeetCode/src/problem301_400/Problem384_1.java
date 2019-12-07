package problem301_400;

import java.util.Random;

public class Problem384_1 {

    class Solution {

        private int[] nums;
        private int[] originalNums;
        private int len;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            originalNums = nums.clone();
            this.len = nums.length;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            nums = originalNums;
            originalNums = nums.clone();
            return nums;
        }

        private void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = 0; i < len; i++) {
                int nextIndex = i + random.nextInt(len - i);
                swap(i, nextIndex);
            }

            return nums;
        }
    }

}
