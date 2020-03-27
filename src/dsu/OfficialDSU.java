package dsu;

/**
 * UnionFind
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class OfficialDSU {
    public int count;
    private int[] parent;
    private int[] weight;

    public OfficialDSU(int n) {
        count = n;
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public void union(int p, int q) {
        int root_p = find(p);
        int root_q = find(q);
        if (root_p == root_q) return;
        if (weight[root_p] > weight[root_q]) {
            parent[root_q] = root_p;
            weight[root_p] += weight[root_q];
        } else {
            parent[root_p] = root_q;
            weight[root_q] += weight[root_p];
        }
        count--;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int find(int p) {
        return p == parent[p] ? p : (parent[p] = find(parent[p])); // 即算法4里头提到的路径压缩
//
//        while (p != parent[p]) {
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
    }

}
