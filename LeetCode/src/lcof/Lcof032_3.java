package lcof;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lcof032_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> ansList = new ArrayList<>();
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLevelList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            if (isReverse) {
                Collections.reverse(curLevelList);
            }
            ansList.add(curLevelList);
            isReverse = !isReverse;
        }

        return ansList;
    }

}
