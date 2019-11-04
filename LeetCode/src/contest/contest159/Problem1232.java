package contest.contest159;

public class Problem1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n == 2) {
            return true;
        }

        double lastK = (coordinates[1][1] - coordinates[0][1]) * 1.0 / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 1; i < n; i++) {
            double k = (coordinates[i][1] - coordinates[i-1][1]) * 1.0 / (coordinates[i][0] - coordinates[i-1][0]);

            if (k != lastK) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {

    }
    
}
