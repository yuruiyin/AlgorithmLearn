import utils.TreeNode;

import java.util.Map;

/**
 * LintCode614
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode614 {

    class Result {
        int ascMax;
        int descMax;
        Result(int ascMax, int descMax) {
            this.ascMax = ascMax;
            this.descMax = descMax;
        }
    }

    private int ansMax = 1;

    private Result getRes(Result childRes, TreeNode child, int rootVal) {
        int childAscMax = childRes.ascMax;
        int childDescMax = childRes.descMax;
        int resAscMax = 1;
        int resDescMax = 1;
        if (rootVal - child.val == 1) {
            // 降序
            resDescMax = 1 + childDescMax;
        } else if (rootVal - child.val == -1) {
            // 升序
            resAscMax = 1 + childAscMax;
        }
        ansMax = Math.max(ansMax, Math.max(resAscMax, resDescMax));
        return new Result(resAscMax, resDescMax);
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);

        if (leftRes == null && rightRes == null) {
            return new Result(1, 1);
        } else if (leftRes == null) {
            return getRes(rightRes, root.right, root.val);
        } else if (rightRes == null) {
            return getRes(leftRes, root.left, root.val);
        } else {
            // 二者都不为空
            int leftDiff = Math.abs(root.val - root.left.val);
            int rightDiff = Math.abs(root.val - root.right.val);

            if (leftDiff != 1 && rightDiff != 1) {
                return new Result(1, 1);
            } else if (leftDiff != 1) {
                return getRes(rightRes, root.right, root.val);
            } else if (rightDiff != 1) {
                return getRes(leftRes, root.left, root.val);
            } else {
                // 两边diff要相反再可连在一起
                int signLeftDiff = root.val - root.left.val;
                int signRightDiff = root.val - root.right.val;
                if (signLeftDiff == 1) {
                    // 左边降序， 看右边是否升序
                    if (signRightDiff == -1) {
                        // 连在一起
                        ansMax = Math.max(ansMax, leftRes.descMax + rightRes.ascMax + 1);
                        return new Result(rightRes.ascMax + 1, leftRes.descMax + 1);
                    } else {
                        int descMax = Math.max(leftRes.descMax, rightRes.descMax) + 1;
                        ansMax = Math.max(ansMax, descMax);
                        return new Result(1, descMax);
                    }
                } else {
                    // 左边升序，看右半是否降序
                    if (signRightDiff == 1) {
                        // 连在一起
                        ansMax = Math.max(ansMax, leftRes.ascMax + rightRes.descMax + 1);
                        return new Result(leftRes.ascMax + 1, rightRes.descMax + 1);
                    } else {
                        // 两边都升序
                        int ascMax = Math.max(leftRes.ascMax, rightRes.ascMax) + 1;
                        ansMax = Math.max(ansMax, ascMax);
                        return new Result(ascMax, 1);
                    }
                }
            }
        }
    }

    public int longestConsecutive2(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        dfs(root);
        return ansMax;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(new LintCode614().longestConsecutive2(root));
    }

}
