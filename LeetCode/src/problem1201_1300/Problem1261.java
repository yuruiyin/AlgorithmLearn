package problem1201_1300;

import common.TreeNode;

public class Problem1261 {

    class FindElements {

        private TreeNode root;

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                root.left.val = 2 * root.val + 1;
                dfs(root.left);
            }

            if (root.right != null) {
                root.right.val = 2 * root.val + 2;
                dfs(root.right);
            }
        }

        private boolean findInternal(TreeNode root, int target) {
            if (root == null) {
                return false;
            }

            if (root.val == target) {
                return true;
            }

            if (target < root.val) {
                return false;
            }

            return findInternal(root.left, target) || findInternal(root.right, target);
        }

        public FindElements(TreeNode root) {
            root.val = 0;
            dfs(root);
            this.root = root;
        }

        public boolean find(int target) {
            return findInternal(root, target);
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
