package problem301_400;

public class Problem334 {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < small) {
                small = num;
            } else if (num > small && num < big) {
                big = num;
            } else if (num > big) {
                return true;
            }
        }

        return false;
    }

}
