package contest.contest311;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C {

    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode ansRoot = root;
        List<TreeNode> nodeList = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> oddNodeList = new ArrayList<>();
            List<TreeNode> evenNodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 1) {
                    oddNodeList.add(node);
                } else {
                    evenNodeList.add(node);
                }
                if (node.left == null) {
                    // 叶子
                    continue;
                }
                TreeNode left = node.left;
                TreeNode right = node.right;
                queue.add(left);
                queue.add(right);
            }
            level++;
            for (int i = oddNodeList.size() - 1; i >= 0; i--) {
                nodeList.add(oddNodeList.get(i));
            }
            nodeList.addAll(evenNodeList);
        }

        System.out.println(nodeList.size());

        int idx = 1;
        ansRoot = nodeList.get(0);
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue1.add(nodeList.get(0));

        while ((level--) > 1) {
            for (int i = (1 << idx) - 1; i <= (1 << (idx + 1)) - 2; i+=2) {
                TreeNode cur = queue1.poll();
                cur.left = nodeList.get(i);
                cur.right = nodeList.get(i + 1);
                cur.left.left = null;
                cur.left.right = null;
                cur.right.left = null;
                cur.right.right = null;
                queue1.add(cur.left);
                queue1.add(cur.right);
            }
            idx++;
        }
        return ansRoot;
    }

}
