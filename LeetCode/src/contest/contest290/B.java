package contest.contest290;

public class B {

    public int countLatticePoints(int[][] circles) {
        int ans = 0;
        for (int i = -200; i <= 200; i++) {
            for (int j = -200; j <= 200; j++) {
                for (int[] circle: circles) {
                    int x = circle[0];
                    int y = circle[1];
                    int r = circle[2];
                    int diffX = Math.abs(i - x);
                    int diffY = Math.abs(j - y);
                    if (diffX * diffX + diffY * diffY <= r * r) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
