package contest.contest197;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class D {

    private double getAns(double x, double y, int[][] positions) {
        double ans = 0;
        for (int[] pos : positions) {
            ans += Math.sqrt((x - pos[0]) * (x - pos[0]) + (y - pos[1]) * (y - pos[1]));
        }
        return ans;
    }

    public double getMinDistSum(int[][] positions) {
        double x = 0;
        double y = 0;
        double ansMin = Double.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                double dis = getAns(i, j, positions);
                if (dis < ansMin) {
                    ansMin = dis;
                    x = i;
                    y = j;
                }
            }
        }

        ansMin = Double.MAX_VALUE;
        for (double i = -0.500; i <= 0.500; i += 0.001) {
            double preY = Double.MAX_VALUE;
            for (double j = -0.500; j <= 0.500; j += 0.001) {
                double x1 = x + i;
                double y1 = y + j;
                double dis = getAns(x1, y1, positions);
                if (dis < ansMin) {
                    ansMin = dis;
                }

                if (dis >= preY) {
                    break;
                }

                preY = dis;
            }
        }

        return ansMin;
    }

}
