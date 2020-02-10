package problem1001_1100;

import common.TreeNode;

public class Problem1008 {

    private int[] preorder;
    private int len;

    private TreeNode dfs(int start, int end) {
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        int leftStart = start + 1;
        int leftEnd;
        for (leftEnd = start + 1; leftEnd < len; leftEnd++) {
            if (preorder[leftEnd] > rootVal) {
                break;
            }
        }

        leftEnd--;

        if (leftEnd >= leftStart) {
            root.left = dfs(leftStart, leftEnd);
        }

        int rightStart = leftEnd + 1;
        int rightEnd = end;

        if (rightEnd >= rightStart) {
            root.right = dfs(rightStart, rightEnd);
        }

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        len = preorder.length;
        this.preorder = preorder;
        return dfs(0, len - 1);
    }

}

//    返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
//
//        (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
//
//
//
//        示例：
//
//        输入：[8,5,1,7,10,12]
//        输出：[8,5,10,1,7,null,12]
//
//
//
//        提示：
//
//        1 <= preorder.length <= 100
//        先序 preorder 中的值是不同的。
