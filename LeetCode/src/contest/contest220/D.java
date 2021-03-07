package contest.contest220;

import dsu.TreeDSU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/20
 */
public class D {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        // [0, n - 1]

        List<int[]> queryList = new ArrayList<>();
        int len = queries.length;
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            queryList.add(new int[]{query[0], query[1], query[2], i});
        }

        queryList.sort(Comparator.comparingInt(o -> o[2]));

        boolean[] ansArr = new boolean[len];
        TreeDSU treeDSU = new TreeDSU(n);

        int i = 0;

        for (int[] query : queryList) {
            int u = query[0];
            int v = query[1];
            int limit = query[2];
            int idx = query[3];
            while (i < edgeList.length && edgeList[i][2] < limit) {
                treeDSU.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            if (treeDSU.connected(u, v)) {
                ansArr[idx] = true;
            }
        }
        return ansArr;
    }
    
    public static void main(String[] args) {
        boolean[] ansArr = new D().distanceLimitedPathsExist(30, new int[][]{
                {9,14,88},{11,27,51},{29,22,58},{29,27,26},{18,20,97},{25,4,12},{2,4,16},{17,18,40},{21,9,37},{3,14,6},{8,23,24},{7,27,39},{24,16,95},{9,29,19},{9,18,22},{26,21,12},{12,14,81},{6,14,79},{3,16,47},{13,19,18},{24,15,59},{14,20,26},{24,20,14},{25,26,7},{13,12,81},{1,0,51},{17,4,39},{8,16,77},{28,9,53},{23,6,40},{29,18,31},{10,9,35},{29,27,7},{1,29,91},{10,19,70},{28,29,58},{20,17,86},{21,14,77},{19,4,43},{26,21,22},{2,26,61},{24,22,16}
        }, new int[][]{
                {21,10,1},{14,2,21},{15,11,64},{21,27,17},{3,26,1},{26,18,93},{8,6,5},{18,19,62},{19,18,30},{7,25,76},{0,20,78},{11,6,16},{16,2,91},{22,21,66},{28,24,95},{19,4,18},{14,23,37},{19,27,7},{15,10,83},{23,5,59},{17,12,9},{26,5,90},{26,24,46},{21,29,30},{24,18,54},{27,3,94},{1,23,75},{28,22,75},{27,11,32},{11,20,62},{12,11,10},{17,14,4},{27,22,67},{19,0,25},{16,24,38},{23,6,35},{11,21,96},{28,14,38},{29,17,8},{10,21,85},{2,27,97},{25,13,98}
        });
    }

}
