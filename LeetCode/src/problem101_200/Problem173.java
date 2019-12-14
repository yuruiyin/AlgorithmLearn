package problem101_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem173 {

    class BSTIterator {

        private List<Integer> ansList;
        private int index = 0;

        public BSTIterator(TreeNode root) {
            ansList = new ArrayList<>();
            inOrder(root);
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            ansList.add(root.val);
            inOrder(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return ansList.get(index++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < ansList.size();
        }
    }

}
