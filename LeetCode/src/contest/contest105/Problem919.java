package contest.contest105;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem919 {

    class CBTInserter {

        private List<TreeNode> treeList;

        private void createTreeList(TreeNode root) {
            treeList = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                treeList.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        public CBTInserter(TreeNode root) {
            createTreeList(root);
        }

        public int insert(int v) {
            int curNodeIndex = treeList.size();
            int parentIndex = (curNodeIndex - 1) / 2;
            TreeNode parent = treeList.get(parentIndex);
            TreeNode newNode = new TreeNode(v);
            if (curNodeIndex == parentIndex * 2 + 1) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            treeList.add(newNode);
            return parent.val;
        }

        public TreeNode get_root() {
            return treeList.get(0);
        }
    }

}
