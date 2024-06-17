package utils;

/**
 * 二叉索引树 （Fenwick Tree）
 * 用于求解动态更新数组的情况下需要求数组前缀和（区间求和）的情况
 * 更新和查询的时间复杂度均为O(logn)
 */
public class FenwickTree {

    private final int[] tree;
    private final int size;

    public FenwickTree(int n) {
        this.size = n;
        this.tree = new int[n + 1];
    }

    /**
     * 更新树中的第index个位置的值，加上delta
     */
    public void update(int index, int delta) {
        index++;
        while (index <= size) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    /**
     * 计算前缀和, 从0到index的和
     */
    public int query(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }

    /**
     * 获取区间[left, right]的和
     */
    public int rangeQuery(int left, int right) {
        if (left > right) {
            return 0;
        }
        return query(right) - query(left - 1);
    }

}
