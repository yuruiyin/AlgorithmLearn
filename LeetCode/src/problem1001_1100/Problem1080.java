package problem1001_1100;

import common.TreeNode;

public class Problem1080 {

    private int limit;

    private boolean dfs(TreeNode root, int prevSum) {
        if (root.left == null && root.right == null) {
            if (prevSum + root.val < limit) {
                return true;
            }
            return false;
        }

        boolean isNeedRemoveLeftChild = false;
        boolean hasLeft = false;
        if (root.left != null) {
            hasLeft = true;
            isNeedRemoveLeftChild = dfs(root.left, prevSum + root.val);
            if (isNeedRemoveLeftChild) {
                root.left = null;
            }
        }

        boolean isNeedRemoveRightChild = false;
        boolean hasRight = false;
        if (root.right != null) {
            hasRight = true;
            isNeedRemoveRightChild = dfs(root.right, prevSum + root.val);
            if (isNeedRemoveRightChild) {
                root.right = null;
            }
        }

        if (hasLeft && hasRight && isNeedRemoveLeftChild && isNeedRemoveRightChild) {
            return true;
        }

        if (hasLeft && !hasRight && isNeedRemoveLeftChild) {
            return true;
        }

        if (!hasLeft && hasRight && isNeedRemoveRightChild) {
            return true;
        }

        return false;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        boolean isRemoveRoot = dfs(root, 0);
        if (isRemoveRoot) {
            return null;
        }
        return root;
    }
    
    public static void main(String[] args) {
        
    }
    
}
