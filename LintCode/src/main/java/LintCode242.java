import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LintCode242
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode242 {

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<ListNode> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = null;
            ListNode pre = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    head = new ListNode(node.val);
                    pre = head;
                } else {
                    pre.next = new ListNode(node.val);
                    pre = pre.next;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ansList.add(head);
        }
        
        return ansList;
    }

}
