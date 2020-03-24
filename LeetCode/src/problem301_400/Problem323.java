package problem301_400;

import dsu.TreeDSU;

/**
 * Problem323
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Problem323 {

    // 我的dsu树的版本（非链表版）
    public int countComponentsTreeDSU(int n, int[][] edges) {
        TreeDSU dsu = new TreeDSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.size();
    }

}
