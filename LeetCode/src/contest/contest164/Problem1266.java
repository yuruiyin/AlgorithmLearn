package contest.contest164;

public class Problem1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }


        int prevX = points[0][0];
        int prevY = points[0][1];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            ans += Math.max(Math.abs(points[i][0] - prevX), Math.abs(points[i][1] - prevY));
            prevX = points[i][0];
            prevY = points[i][1];
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
