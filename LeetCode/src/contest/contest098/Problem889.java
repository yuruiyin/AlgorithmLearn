package contest.contest098;

import common.TreeNode;

public class Problem889 {

    private int[] pre;
    private int[] post;
    private int len;

    private TreeNode dfs(int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd || preStart >= len && postStart >= len) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preStart]);

        if (preStart == preEnd) {
            return node;
        }

        int next = pre[preStart + 1];
        int nextPostEnd = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == next) {
                nextPostEnd = i;
                break;
            }
        }

        int offset = nextPostEnd - postStart;

        node.left = dfs(preStart + 1, preStart + 1 + offset, postStart, nextPostEnd);
        node.right = dfs(preStart + 2 + offset, preEnd, nextPostEnd + 1, postEnd - 1);
        return node;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        len = pre.length;
        return dfs(0, len - 1, 0, len - 1);
    }
    
    public static void main(String[] args) {
        new Problem889().constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
    }

}
