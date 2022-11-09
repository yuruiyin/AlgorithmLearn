package doubleContest.round087;

import java.util.Arrays;

public class C {

    private void calc(int[] countArr, int num) {
        for (int i = 0; i < 32; i++) {
            int mod = num % 2;
            countArr[i] += mod;
            num /= 2;
        }
    }

    public int[] smallestSubarrays(int[] nums) {
        int len = nums.length;

//        int[][] oneCountArr = new int[len][32];
//        for (int i = 0; i < 32; i++) {
//
//        }
//
//        int[] sufMaxOrArr = new int[len];
//        sufMaxOrArr[len - 1] = nums[len - 1];
//        for (int i = len - 2; i >= 0; i--) {
//            sufMaxOrArr[i] = sufMaxOrArr[i + 1] | nums[i];
//        }

        int[] ansArr = new int[len];
        ansArr[len - 1] = 1;
        int[] countArr = new int[32];
        calc(countArr, nums[len - 1]);
        int end = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            calc(countArr, nums[i]);
            int[] oldCountArr = Arrays.copyOf(countArr, 32);
            int[] tmpCountArr = Arrays.copyOf(countArr, 32);
            int newEnd = end;
            for (int j = end; j > i; j--) {
                int num = nums[j];
                for (int k = 0; k < 32; k++) {
                    int mod = num % 2;
                    tmpCountArr[k] -= mod;
                    num /= 2;
                }
                boolean isOk = true;
                for (int k = 0; k < 32; k++) {
                    if (oldCountArr[k] > 0 && tmpCountArr[k] == 0) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    break;
                }
                countArr = Arrays.copyOf(tmpCountArr, 32);
                newEnd = j - 1;
            }
            end = newEnd;
            ansArr[i] = end - i + 1;
        }
        return ansArr;
    }

}
