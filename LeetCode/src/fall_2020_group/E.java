package fall_2020_group;

import common.TreeNode;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/19
 */
public class E {

    private int n;
    private int[] degree;

    private int getCount(TreeNode root) {
        return root == null ? 0 : getCount(root.left) + getCount(root.right) + 1;
    }

    private void calcDegree(TreeNode parent, TreeNode root) {
        if (root == null) {
            return;
        }

        int count = 0;
        if (root.left != null) {
            count++;
        }

        if (root.right != null) {
            count++;
        }

        if (parent != null) {
            count++;
        }

        degree[root.val] = count;

        calcDegree(root, root.left);
        calcDegree(root, root.right);
    }

    public int navigation(TreeNode root) {
        this.n = getCount(root);
        degree = new int[n + 1];
        calcDegree(null, root);

        boolean hasBigger2 = false;
        boolean has2 = false;
        int count3 = 0;
        int count1 = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] > 2) {
                hasBigger2 = true;
            } else if (degree[i] == 2) {
                has2 = true;
            } else {
                count1++;
            }
        }

        if (!hasBigger2) {
            return 1;
        }

        if (count1 == n - 1) {
            return 2;
        }

        return 3;
    }

}
