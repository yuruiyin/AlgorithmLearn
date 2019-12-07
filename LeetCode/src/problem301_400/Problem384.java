package problem301_400;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem384 {

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

        private List<Integer> getArrayList() {
            List<Integer> ansList = new ArrayList<>();
            for (int num : nums) {
                ansList.add(num);
            }
            return ansList;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> numList = getArrayList();

            for (int i = 0; i < len; i++) {
                int removedIndex = random.nextInt(numList.size());
                nums[i] = numList.get(removedIndex);
                numList.remove(removedIndex);
            }

            return nums;
        }
    }

}
