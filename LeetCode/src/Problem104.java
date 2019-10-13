import common.TreeNode;

public class Problem104 {

    private int maxD = 0;

    private void getMaxDepth(TreeNode root, int level) {
        if (root == null) {
            if (level > maxD) {
                maxD = level;
            }
            return;
        }

        getMaxDepth(root.left, level + 1);
        getMaxDepth(root.right, level + 1);
    }

    public int maxDepth(TreeNode root) {
        getMaxDepth(root, 0);
        return maxD;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        System.out.println(new Problem104().maxDepth(root));
    }
    
}
