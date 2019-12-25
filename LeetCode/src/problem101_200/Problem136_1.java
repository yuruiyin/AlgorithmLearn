package problem101_200;

public class Problem136_1 {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num: nums) {
            xor ^= num;
        }
        return xor;
    }

}
