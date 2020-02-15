package lcof;

public class Lcof056_2 {

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int ans = 0;

        for (int bit = 31; bit >= 0; bit--) {
            int bitOneCount = 0;
            for (int i = 0; i < len; i++) {
                bitOneCount += (nums[i] & (1 << bit)) != 0 ? 1 : 0;
            }

            ans <<= 1;
            if (bitOneCount % 3 == 1) {
                ans += 1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Lcof056_2().singleNumber(new int[]{1, 1, 6, 1}));
    }

}
