package doubleContest.round095;

public class C {

    public int xorBeauty(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

}
