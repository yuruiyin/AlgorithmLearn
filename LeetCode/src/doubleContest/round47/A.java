package doubleContest.round47;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class A {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE;
        for (int[] point: points) {
            int x1 = point[0];
            int y1 = point[1];
            if (x1 == x || y1 == y) {
                minDis = Math.min(minDis, Math.abs(x - x1) + Math.abs(y - y1));
            }
        }

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            if ((x1 == x || y1 == y) &&  Math.abs(x - x1) + Math.abs(y - y1) == minDis) {
                return i;
            }
        }
        return -1;
    }

}
