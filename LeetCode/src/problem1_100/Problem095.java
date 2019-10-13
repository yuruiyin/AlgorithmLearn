package problem1_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem095 {

    private List<TreeNode> getAllBSTs(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            // 说明上一层节点没有左子节点或右子节点
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = getAllBSTs(start, i - 1);
            List<TreeNode> rightTrees = getAllBSTs(i + 1, end);

            for (TreeNode l: leftTrees) {
                for (TreeNode r: rightTrees) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = l;
                    curTree.right = r;
                    trees.add(curTree);
                }
            }
        }

        return trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return getAllBSTs(1, n);
    }

    public static void main(String[] args) {

    }

}
