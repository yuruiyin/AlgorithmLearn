package problem401_500;

public class Problem421 {

    public int findMaximumXOR(int[] nums) {
        int xorMax = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int xor = nums[i] ^ nums[j];
                xorMax = Math.max(xorMax, xor);
            }
        }
        return xorMax;
    }

}
