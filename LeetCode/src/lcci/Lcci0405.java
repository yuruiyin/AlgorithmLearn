package lcci;

import common.TreeNode;

public class Lcci0405 {

    class Result {
        boolean isValid;
        int min;
        int max;
        Result(boolean isValid, int min, int max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);

        int min = root.val;
        int max = root.val;

        if (leftRes != null) {
            if (!leftRes.isValid || leftRes.max >= root.val) {
                return new  Result(false, -1, -1);
            }

            min = leftRes.min;
        }

        if (rightRes != null) {
            if (!rightRes.isValid || rightRes.min <= root.val) {
                return new Result(false, -1, -1);
            }

            max = rightRes.max;
        }

        return new Result(true, min, max);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root).isValid;
    }

}
