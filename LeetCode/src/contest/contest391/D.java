package contest.contest391;

public class D {

    public int minimumDistance(int[][] points) {
        int maxSum = 0;
        int minSum = (int) 1e9;
        int maxDiff = (int) -1e9;
        int minDiff = (int) 1e9;
        for (int[] p: points) {
            int x = p[0];
            int y = p[1];
            if (x + y > maxSum) {
                maxSum = x + y;
            }
            if (x + y < minSum) {
                minSum = x + y;
            }

            if (x - y > maxDiff) {
                maxDiff = x - y;
            }
            if (x - y < minDiff) {
                minDiff = x - y;
            }
        }

        return Math.min(maxSum - minSum, maxDiff - minDiff);
    }

}
