package dianfeng_contest.S202;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/20
 */
public class B {

    private int[] arr;
    private int len;
    private int k;

    private long dfs(long curIdx, int level) {
        if (curIdx >= len) {
            return 0;
        }

        long ans = 0;
        for (long i = curIdx * k + 1; i <= curIdx * k + k && i < len; i++) {
            ans += (arr[(int) curIdx] ^ arr[(int) i]) + dfs(i, level + 1);
        }

        return ans;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param k int整型 表示完全k叉树的叉数k
     * @param a int整型一维数组 表示这棵完全k叉树的Bfs遍历序列的结点编号
     * @return long长整型
     */
    public long tree2 (int k, int[] a) {
        // write code here
        this.arr = a;
        this.k = k;
        this.len = arr.length;

        return dfs(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new B().tree2(2, new int[]{1,2,3,4,5}));
    }

}
