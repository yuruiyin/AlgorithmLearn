package problem401_500;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem437 {

    private int ansCount = 0;

    private void dfs(TreeNode root, int sum, List<Integer> prevPathSumList) {
        if (root.val == sum) {
            ansCount++;
        }

        // 更新路径和列表
        for (int i = 0; i < prevPathSumList.size(); i++) {
            // 跟前面的路径连起来计算路径和
            int newSum = prevPathSumList.get(i) + root.val;
            prevPathSumList.set(i, newSum);
            if (newSum == sum) {
                ansCount++;
            }
        }
        prevPathSumList.add(root.val);

        if (root.left != null) {
            dfs(root.left, sum, prevPathSumList);
        }

        if (root.right != null) {
            dfs(root.right, sum, prevPathSumList);
        }

        prevPathSumList.remove(prevPathSumList.size() - 1);
        for (int i = 0; i < prevPathSumList.size(); i++) {
            prevPathSumList.set(i, prevPathSumList.get(i) - root.val);
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        dfs(root, sum, new ArrayList<>());
        return ansCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        System.out.println(new Problem437().pathSum(root, 8));

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//
//        System.out.println(new Problem437().pathSum(root, 22));
    }


}
