package contest.contest232;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/14
 */
public class B {

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] countArr = new int[n + 1];
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            countArr[u]++;
            countArr[v]++;
            if (countArr[u] > 1) {
                return u;
            }

            if (countArr[v] > 1) {
                return v;
            }
        }

        return -1;
    }

}
