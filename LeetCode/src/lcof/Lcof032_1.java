package lcof;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lcof032_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                ansList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        int size = ansList.size();
        int[] ansArr = new int[size];
        for (int i = 0; i < size; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

}
