package problem501_600;

import common.TreeNode;
import utils.PrintUtil;

import java.util.*;

/**
 * Problem545
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class Problem545 {

    private TreeNode leftMostNode;

    private void getLeft(TreeNode root, List<Integer> leftList) {
        root = root.left;
        while (root != null) {
            leftList.add(root.val);
            leftMostNode = root;
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void getLeaf(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            if (root != leftMostNode) {
                leafList.add(root.val);
            }
            return;
        }

        getLeaf(root.left, leafList);
        getLeaf(root.right, leafList);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void getRight(TreeNode root, List<Integer> rightList) {
        root = root.right;
        while (root != null) {
            if (!isLeaf(root)) {
                rightList.add(root.val);
            }
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }

        if (root.left == null && root.right == null) {
            ansList.add(root.val);
            return ansList;
        }

        List<Integer> leftList = new ArrayList<>();
        List<Integer> leafList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        ansList.add(root.val);
        getLeft(root, leftList);
        getLeaf(root, leafList);
        getRight(root, rightList);
        ansList.addAll(leftList);
        ansList.addAll(leafList);
        Collections.reverse(rightList);
        ansList.addAll(rightList);
        return ansList;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> ansList = new Problem545().boundaryOfBinaryTree(root);
        PrintUtil.printIntList(ansList);
    }

}
