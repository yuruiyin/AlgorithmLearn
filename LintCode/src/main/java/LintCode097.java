import utils.TreeNode;

/**
 * LintCode097
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode097 {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

}
