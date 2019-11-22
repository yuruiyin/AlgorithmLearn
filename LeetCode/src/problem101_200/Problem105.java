package problem101_200;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem105 {

    private int[] preorder;
    //中序遍历中元素的索引，主要为了去除dfs中的for循环，如下
    private Map<Integer, Integer> inorderNumIndexMap = new HashMap<>();

    /**
     * 思路：分治，前序遍历的第一个元素就是当前子树的根节点，然后通过这个根节点的值去中序遍历中寻找，假设当前中序遍历是[inStart, inEnd],
     * 若找到的index为rootIndexInorder，那么[inStart, rootIndexInorder-1]就是左子树，[rootIndexInorder+1, inEnd]就是右子树。
     *
     * @param preStart 当前子树前序遍历的起始位置
     * @param preEnd   当前子树前序遍历的终止位置
     * @param inStart  当前子树中序遍历的起始位置
     * @return root
     */
    private TreeNode dfs(int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorder = inorderNumIndexMap.get(rootVal);
        int leftCount = rootIndexInorder - inStart;
        root.left = dfs(preStart + 1, preStart + leftCount, inStart);
        root.right = dfs(preStart + leftCount + 1, preEnd, rootIndexInorder + 1);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        if (len == 1) {
            return new TreeNode(preorder[0]);
        }

        for (int i = 0; i < len; i++) {
            inorderNumIndexMap.put(inorder[i], i);
        }

        this.preorder = preorder;
        return dfs(0, len-1, 0);
    }
    
    public static void main(String[] args) {

    }
    
}
