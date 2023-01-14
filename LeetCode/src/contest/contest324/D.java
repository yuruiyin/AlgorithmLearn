package contest.contest324;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D {

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int u = q[0];
            int v = q[1];

            int tmpU = u;
            int tmpV = v;
            int count1 = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(tmpU, 0);
            while (tmpU != 1 && tmpU != v) {
                tmpU >>>= 1;
                count1++;
                map.put(tmpU, count1);
            }

            if (tmpU == v) {
                // v是u的祖先
                ansArr[i] = count1 + 1;
                continue;
            }

            int count2 = 0;
            while (!map.containsKey(tmpV)) {
                tmpV >>>= 1;
                count2++;
            }

            ansArr[i] = count2 + map.get(tmpV) + 1;
        }
        return ansArr;
    }

    public static void main(String[] args) {
//        5
//                [[17,21],[23,5],[15,7],[3,21],[31,9],[5,15],[11,2],[19,7]]
        new D().cycleLengthQueries(5, new int[][]{
                {17,21},{23,5},{15,7},{3,21},{31,9},{5,15},{11,2},{19,7}
        });
        System.out.println("hello world");
    }

}
