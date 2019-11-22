package problem101_200;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem106 {

    private int[] postOrder;
    private Map<Integer, Integer> inorderNumIndexMap = new HashMap<>();

    private TreeNode dfs(int postStart, int postEnd, int inStart) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postOrder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = inorderNumIndexMap.get(rootVal);
        int leftChildCount = rootIndexInorder - inStart;
        root.left = dfs(postStart, postStart + leftChildCount - 1, inStart);
        root.right = dfs(postStart + leftChildCount, postEnd - 1, rootIndexInorder+1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }

        if (len == 1) {
            return new TreeNode(inorder[0]);
        }

        for (int i = 0; i < len; i++ ) {
            inorderNumIndexMap.put(inorder[i], i);
        }

        this.postOrder = postorder;
        return dfs(0, len-1, 0);
    }
    
    public static void main(String[] args) {

    }
    
}
