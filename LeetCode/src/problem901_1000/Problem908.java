package problem901_1000;

public class Problem908 {

    public int smallestRangeI(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (max - min <= 2 * k) {
            return 0;
        }

        return max - min - 2 * k;
    }

}
