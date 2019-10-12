import common.TreeNode;

public class Problem222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesBinarySearch(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) {
            // 可以确定左子树是满的，右子树可能满也可能不满，不断递归遍历即可。
            return countNodesBinarySearch(root.right) + (1<<leftLevel);
        } else {
            // 右子树是满二叉树(比左子树小一层)，左子树不是满的
            return countNodesBinarySearch(root.left) + (1<<rightLevel);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }

        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new Problem222().countNodesBinarySearch(root));
    }

}
