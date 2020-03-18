import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LintCode069
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode069 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ansList.add(list);
        }

        return ansList;
    }

}
