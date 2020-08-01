package contest.contest199;

import common.TreeNode;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/26
 */
public class C {

    private int distance;
    private Set<String> set;

    class Result {
        int hashCode;
        int len;
        Result(int hashCode, int len) {
            this.hashCode = hashCode;
            this.len = len;
        }
    }

    private List<Result> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            // 叶子
            Result res = new Result(root.hashCode(), 1);
            List<Result> list = new ArrayList<>();
            list.add(res);
            return list;
        }

        List<Result> leftResList = dfs(root.left);
        List<Result> rightResList = dfs(root.right);

        for (Result leftRes : leftResList) {
            for (Result rightRes : rightResList) {
                int leftLen = leftRes.len;
                int rightLen = rightRes.len;
                if (leftLen + rightLen <= distance) {
                    set.add(leftRes.hashCode + " " + rightRes.hashCode);
                }
            }
        }

        for (Result leftRes : leftResList) {
            leftRes.len++;
        }

        for (Result rightRes : rightResList) {
            rightRes.len++;
        }

        List<Result> resList = new ArrayList<>();
        resList.addAll(leftResList);
        resList.addAll(rightResList);
        return resList;
    }

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        set = new HashSet<>();
        dfs(root);
        return set.size();
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new C().countPairs(root, 2));
    }

}
