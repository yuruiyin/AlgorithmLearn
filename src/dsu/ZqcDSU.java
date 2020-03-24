package dsu;

import java.util.Arrays;

/**
 * 群里zqc大佬的DSU
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class ZqcDSU {

    private int[] data;
    private int size;

    public ZqcDSU(int n) {
        data = new int[n];
        Arrays.fill(data, -1);
        size = n;
    }

    private void swap(int x, int y) {
        int t = data[x];
        data[x] = data[y];
        data[y] = t;
    }

    public boolean union(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (data[y] < data[x]) {
                swap(x, y);
            }
            data[x] += data[y];
            data[y] = x;
            size--;
        }
        return x != y;
    }

    public boolean connected(int x, int y) {
        return root(x) == root(y);
    }

    private int root(int x) {
        return data[x] < 0 ? x : (data[x] = root(data[x])); // 这里是精髓,即算法4里头提到的路径压缩
    }

    public int size() {
        return size;
    }

}
