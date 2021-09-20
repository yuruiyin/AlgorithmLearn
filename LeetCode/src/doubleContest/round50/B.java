package doubleContest.round50;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/17
 */
public class B {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int cx = q[0];
            int cy = q[1];
            int r = q[2];
            int count = 0;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if ((x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

}
