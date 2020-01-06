package doubleContest.round16;

import common.TreeNode;

import java.util.LinkedList;

public class Problem1302 {

    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmpAns = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmpAns += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans = tmpAns;
        }

        return ans;
    }
    
}
