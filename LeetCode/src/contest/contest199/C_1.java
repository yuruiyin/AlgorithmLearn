package contest.contest199;

import common.TreeNode;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/26
 */
public class C_1 {

    private int distance;
    private int ansCount = 0;

    private List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            // 叶子
            return new ArrayList<>(Arrays.asList(1));
        }

        List<Integer> leftResList = dfs(root.left);
        List<Integer> rightResList = dfs(root.right);

        for (int leftLen : leftResList) {
            for (int rightLen : rightResList) {
                if (leftLen + rightLen <= distance) {
                    ansCount++;
                }
            }
        }

        List<Integer> resList = new ArrayList<>();
        resList.addAll(leftResList);
        resList.addAll(rightResList);
        for (int i = 0; i < resList.size(); i++) {
            resList.set(i, resList.get(i) + 1);
        }
        return resList;
    }

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return ansCount;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new C_1().countPairs(root, 2));
    }

}
