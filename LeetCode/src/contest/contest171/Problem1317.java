package contest.contest171;

import utils.PrintUtil;

public class Problem1317 {

    private boolean hasZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }

        return false;
    }

    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - left;
        while (left <= right) {
            if (!hasZero(left) && !hasZero(right)) {
                return new int[]{left, right};
            }
            left++;
            right--;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem1317().getNoZeroIntegers(1099999999);
        PrintUtil.printIntArray(ansArr);
    }

}
