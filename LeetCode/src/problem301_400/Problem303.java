package problem301_400;

public class Problem303 {

    class NumArray {

        private int[] preSumArr;

        private void createPreSumArr(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return;
            }
            preSumArr = new int[len];
            preSumArr[0] = nums[0];
            for (int i = 1; i < len; i++) {
                preSumArr[i] = preSumArr[i-1] + nums[i];
            }
        }

        public NumArray(int[] nums) {
            createPreSumArr(nums);
        }

        public int sumRange(int i, int j) {
            if (preSumArr == null) {
                return 0;
            }
            return i == 0 ? preSumArr[j] : preSumArr[j] - preSumArr[i-1];
        }
    }

}
