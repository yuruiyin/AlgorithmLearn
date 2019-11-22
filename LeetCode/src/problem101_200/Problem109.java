package problem101_200;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem109 {

    private TreeNode dfs(List<Integer> numList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(numList.get(mid));
        root.left = dfs(numList, start, mid - 1);
        root.right = dfs(numList, mid + 1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> numList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            numList.add(cur.val);
            cur = cur.next;
        }

        return dfs(numList, 0, numList.size() - 1);
    }
    
    public static void main(String[] args) {

    }
    
}
