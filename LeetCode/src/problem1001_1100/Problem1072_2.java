package problem1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1072_2 {

    class Node {
        Node left;
        Node right;
        int val;
        Node() {
            this.val = 0;
        }
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int ans = 0;
        Node root = new Node();
        for (int[] row: matrix) {
            int c0 = row[0];
            Node cur = root;
            for (int c : row) {
                if (c == c0) {
                    // 往左
                    if (cur.left == null) {
                        cur.left = new Node();
                    }
                    cur = cur.left;
                } else {
                    // 往右
                    if (cur.right == null) {
                        cur.right = new Node();
                    }
                    cur = cur.right;
                }
            }
            cur.val++;
            if (cur.val > ans) {
                ans = cur.val;
            }
//            ans = Math.max(ans, cur.val);
        }
        return ans;
    }

}
