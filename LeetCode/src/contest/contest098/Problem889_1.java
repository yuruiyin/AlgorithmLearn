package contest.contest098;

import common.TreeNode;

public class Problem889_1 {

    private int[] pre;
    private int len;
    private int[] postIndexMap;

    private TreeNode dfs(int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd || preStart >= len && postStart >= len) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return node;
        }

        int next = pre[preStart + 1];
        int nextPostEnd = postIndexMap[next];
        int offset = nextPostEnd - postStart;

        node.left = dfs(preStart + 1, preStart + 1 + offset, postStart, nextPostEnd);
        node.right = dfs(preStart + 2 + offset, preEnd, nextPostEnd + 1, postEnd - 1);
        return node;
    }

    private void createPostIndexMap(int[] post) {
        postIndexMap = new int[31];
        for (int i = 0; i < len; i++) {
            postIndexMap[post[i]] = i;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        len = pre.length;
        createPostIndexMap(post);
        return dfs(0, len - 1, 0, len - 1);
    }
    
    public static void main(String[] args) {
        new Problem889_1().constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
    }

}
