package problem1001_1100;

import common.TreeNode;

public class Problem1022 {

    private int ans = 0;
    private static final int MOD = 1000000007;

    private int binaryToInt(StringBuilder sb) {
        int num = 0;
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            int val = sb.charAt(len - i - 1) - '0';
            num += val * (1<<i);
        }
        return num;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans = (ans + binaryToInt(sb)) % MOD;
            return;
        }

        if (root.left != null) {
            sb.append(root.left.val);
            dfs(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            sb.append(root.right.val);
            dfs(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs(root, sb);
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
