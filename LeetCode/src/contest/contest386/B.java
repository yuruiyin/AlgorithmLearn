package contest.contest386;

public class B {

    private long calcArea(int x1, int y1, int x2, int y2, int x11, int y11, int x22, int y22) {
        if (x11 >= x2 || x22 <= x1 || y11 >= y2 || y22 <= y1) {
            return 0;
        }

        long side = Math.min(Math.abs(Math.max(x11, x1) - Math.min(x22, x2)), Math.abs(Math.max(y11, y1) - Math.min(y22, y2)));
        return side * side;
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        int len = bottomLeft.length;
        for (int i = 0; i < len; i++) {
            int x1 = bottomLeft[i][0];
            int y1 = bottomLeft[i][1];
            int x2 = topRight[i][0];
            int y2 = topRight[i][1];
            for (int j = i + 1; j < len; j++) {
                int x11 = bottomLeft[j][0];
                int y11 = bottomLeft[j][1];
                int x22 = topRight[j][0];
                int y22 = topRight[j][1];
                ans = Math.max(ans, calcArea(x1, y1, x2, y2, x11, y11, x22, y22));
            }
        }
        return ans;
    }

}
