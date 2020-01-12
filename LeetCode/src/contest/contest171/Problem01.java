package contest.contest171;

public class Problem01 {

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

}
