package lcci;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lcci0403 {

    public ListNode[] listOfDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<ListNode> nodeList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = null;
            ListNode curListNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (curListNode == null) {
                    curListNode = new ListNode(node.val);
                    head = curListNode;
                } else {
                    curListNode.next = new ListNode(node.val);
                    curListNode = curListNode.next;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            nodeList.add(head);
        }

        int size = nodeList.size();
        ListNode[] listNodeArr = new ListNode[size];
        for (int i = 0; i < size; i++) {
            listNodeArr[i] = nodeList.get(i);
        }

        return listNodeArr;
    }

}
