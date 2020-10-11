package contest.contest209;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/4
 */
public class B {

    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root.val % 2 == 0) {
            return false;
        }

        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> valList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                valList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (level % 2 == 0) {
                if (valList.get(0) % 2 == 0) {
                    return false;
                }
            } else {
                if (valList.get(0) % 2 == 1) {
                    return false;
                }
            }

            for (int i = 1; i < valList.size(); i++) {
                int curVal = valList.get(i);
                if (level % 2 == 0) {
                    if (curVal % 2 == 0 || curVal <= valList.get(i - 1)) {
                        return false;
                    }
                } else {
                    if (curVal % 2 != 0 || curVal >= valList.get(i - 1)) {
                        return false;
                    }
                }
            }
            level++;
        }

        return true;

    }

}
