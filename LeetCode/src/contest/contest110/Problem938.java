package contest.contest110;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem938 {

    private void inorder(TreeNode root, List<Integer> valueList) {
        if (root == null) {
            return;
        }

        inorder(root.left, valueList);
        valueList.add(root.val);
        inorder(root.right, valueList);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> valueList = new ArrayList<>();
        inorder(root, valueList);
        int sum = 0;
        for (Integer value: valueList) {
            if (value > R) {
                break;
            }

            if (value >= L) {
                sum += value;
            }
        }

        return sum;
    }
    
    public static void main(String[] args) {

    }
    
}
