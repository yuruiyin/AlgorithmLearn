package problem201_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem272_1 {

    private List<Integer> ansList;  // 根据diff从大到小排序
    private double target;
    private int k;

    // 中序遍历，就是一个有序的。如果遍历到某一个值的时候，他跟target的差距比已有列表中的某个差距值更大，说明target靠近前面，因此后面无需再遍历了。
    // 类似一个滑动窗口，因为靠近target的k个值一定是一个连续的区间。
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (ansList.size() < k) {
            ansList.add(root.val);
        } else {
            double curDiff = Math.abs(root.val - target);
            double oldDiff = Math.abs(ansList.get(0) - target);
            if (curDiff < oldDiff) {
                ansList.remove(0);
                ansList.add(root.val);
            } else {
                return;
            }
        }

        dfs(root.right);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target = target;
        this.k = k;
        ansList = new ArrayList<>();
        dfs(root);
        return ansList;
    }

}
