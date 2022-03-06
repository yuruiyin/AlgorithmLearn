package contest.contest270;

import common.TreeNode;

/**
 * a
 *
 * @author: yry
 * @date: 2021/12/5
 */
public class C {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // p,q分别在左右子树，或p，q都在左子树或者都在右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

    private TreeNode find(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode left = find(root.left, value);
        if (left != null) {
            return left;
        }

        return find(root.right, value);
    }

    private String ans;

    /**
     * 往下搜索
     */
    private void searchDown(TreeNode cur, TreeNode target, StringBuilder tmpSb) {
        if (cur == null) {
            return;
        }

        if (cur == target) {
            ans = tmpSb.toString();
            return;
        }

        tmpSb.append("L");
        searchDown(cur.left, target, tmpSb);
        tmpSb.deleteCharAt(tmpSb.length() - 1);
        tmpSb.append("R");
        searchDown(cur.right, target, tmpSb);
        tmpSb.deleteCharAt(tmpSb.length() - 1);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode startNode = find(root, startValue);
        TreeNode destNode = find(root, destValue);
        TreeNode lowestAncestor = lowestCommonAncestor(root, startNode, destNode);
        if (lowestAncestor == startNode) {
            searchDown(startNode, destNode, new StringBuilder());
            return ans;
        } else if (lowestAncestor == destNode) {
            searchDown(destNode, startNode, new StringBuilder());
            int len = ans.length();
            StringBuilder sb = new StringBuilder();
            sb.append("U".repeat(len));
            return sb.toString();
        } else {
            searchDown(lowestAncestor, startNode, new StringBuilder());
            int len = ans.length();
            StringBuilder sb = new StringBuilder();
            sb.append("U".repeat(len));
            searchDown(lowestAncestor, destNode, new StringBuilder());
            sb.append(ans);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new C().getDirections(root, 2, 1));
    }

}
