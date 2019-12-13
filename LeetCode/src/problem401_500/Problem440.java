package problem401_500;

public class Problem440 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            long first = cur;    // 当前节点
            long next = cur + 1; // 右侧兄弟节点
            long step = 0; // 当前节点为根的子树的节点个数
            while (first <= n) {
                step += Math.min(n + 1, next) - first;
                first *= 10;
                next *= 10;
            }

            if (step <= k) { // 不在子树中
                cur++;
                k -= step;
            } else { // 在子树中
                cur *= 10;
                k--;
            }
        }

        return cur;
    }

}

//  给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
//
//        注意：1 ≤ k ≤ n ≤ 1e9。
//
//        示例 :
//
//        输入:
//        n: 13   k: 2
//
//        输出:
//        10
//
//        解释:
//        字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。

