package contest.contest324;

import java.util.HashMap;
import java.util.Map;

public class D_1 {

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int u = q[0];
            int v = q[1];
            int count = 0;
            while (u != v) {
                if (u > v) {
                    u >>>= 1;
                } else {
                    v >>>= 1;
                }
                count++;
            }
            ansArr[i] = count + 1;
        }
        return ansArr;
    }

    public static void main(String[] args) {
//        5
//                [[17,21],[23,5],[15,7],[3,21],[31,9],[5,15],[11,2],[19,7]]
        new D_1().cycleLengthQueries(5, new int[][]{
                {17,21},{23,5},{15,7},{3,21},{31,9},{5,15},{11,2},{19,7}
        });
        System.out.println("hello world");
    }

}
