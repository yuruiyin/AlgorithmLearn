package doubleContest.round121;

public class B {

    public int minOperations(int[] nums, int k) {
        int[] bit1CountArr = new int[21];
        for (int num: nums) {
            int idx = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    bit1CountArr[idx]++;
                }
                num >>>= 1;
                idx++;
            }
        }
        int idx = 0;
        int ans = 0;
        while (k > 0) {
            if ((k & 1) != bit1CountArr[idx] % 2) {
                ans++;
            }
            idx++;
            k >>>= 1;
        }
        for (int i = idx; i < 21; i++) {
            if (bit1CountArr[i] % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

}
