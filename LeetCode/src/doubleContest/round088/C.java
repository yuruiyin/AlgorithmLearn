package doubleContest.round088;

public class C {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums1) {
            xor1 ^= num;
        }
        for (int num : nums2) {
            xor2 ^= num;
        }
        int ansXor = 0;
        if (len1 % 2 == 1) {
            ansXor ^= xor2;
        }
        if (len2 % 2 == 1) {
            ansXor ^= xor1;
        }
        return ansXor;
    }

}
