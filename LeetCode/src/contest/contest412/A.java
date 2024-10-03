package contest.contest412;

public class A {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < len; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
            }

            nums[minIdx] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
