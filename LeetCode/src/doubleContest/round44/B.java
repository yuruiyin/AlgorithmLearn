package doubleContest.round44;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/23
 */
public class B {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] lanSetArr = new HashSet[m];
        for (int i = 0; i < m; i++) {
            lanSetArr[i] = new HashSet<>();
            for (int j = 0; j < languages[i].length; j++) {
                lanSetArr[i].add(languages[i][j]);
            }
        }

        List<Integer>[] adj = new ArrayList[m];
        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        boolean[][] hasSameArr = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            List<Integer> neighbors = adj[i];
            Set<Integer> lans1 = lanSetArr[i];
            if (neighbors == null) {
                continue;
            }
            for (int j : neighbors) {
                if (hasSameArr[i][j] || hasSameArr[j][i]) {
                    continue;
                }

                Set<Integer> lans2 = lanSetArr[j];
                for (int lan : lans2) {
                    if (lans1.contains(lan)) {
                        hasSameArr[i][j] = true;
                        hasSameArr[j][i] = true;
                        break;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (lanSetArr[j].contains(i)) {
                    continue;
                }

                List<Integer> neighbors = adj[j];
                if (neighbors == null) {
                    continue;
                }
                for (int next : neighbors) {
                    if (!(hasSameArr[j][next] || hasSameArr[next][j])) {
                        count++;
                        break;
                    }
                }
            }
            min = Math.min(min, count);
        }
        return min;
    }

    public static void main(String[] args) {
//        System.out.println(new B().minimumTeachings(11, new int[][]{
//                {3,11,5,10,1,4,9,7,2,8,6},{5,10,6,4,8,7},{6,11,7,9},{11,10,4},{6,2,8,4,3},{9,2,8,4,6,1,5,7,3,10},{7,5,11,1,3,4},{3,4,11,10,6,2,1,7,5,8,9},{8,6,10,2,3,1,11,5},{5,11,6,4,2}
//        }, new int[][]{
//                {7,9},{3,7},{3,4},{2,9},{1,8},{5,9},{8,9},{6,9},{3,5},{4,5},{4,9},{3,6},{1,7},{1,3},{2,8},{2,6},{5,7},{4,6},{5,8},{5,6},{2,7},{4,8},{3,8},{6,8},{2,5},{1,4},{1,9},{1,6},{6,7}
//        }));

        System.out.println(new B().minimumTeachings(2, new int[][]{
                {2},{1},{2,1},{1},{1,2},{1},{2},{1},{1},{2},{1,2},{1,2},{1,2},{2,1},{1},{2},{1,2}
        }, new int[][]{
                {15,16},{4,13},{3,16},{5,14},{1,7},{2,11},{3,15},{4,16},{7,9},{6,13},{6,16},{4,10},{6,9},{5,6},{7,12},{6,12},{3,7},{4,7},{8,10}
        }));
    }

}
