package contest.contest178;

import common.ListNode;
import common.TreeNode;

public class Problem03 {

    private boolean isOk(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return isOk(head.next, root.left) || isOk(head.next, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null || root == null) {
            return false;
        }

        if (head.val == root.val) {
            boolean isOk = isOk(head, root);
            if (isOk) {
                return true;
            }
        }

        return dfs(head, root.left) || dfs(head, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, root);
    }

}
