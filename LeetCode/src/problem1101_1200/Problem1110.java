package problem1101_1200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1110 {

    private List<TreeNode> ansList;

    private void dfs(TreeNode root, Set<Integer> deleteSet, TreeNode parent, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (deleteSet.contains(root.val)) {
            if (root.left != null) {
                if (!deleteSet.contains(root.left.val)) {
                    ansList.add(root.left);
                }
            }

            if (root.right != null) {
                if (!deleteSet.contains(root.right.val)) {
                    ansList.add(root.right);
                }
            }

            if (parent == null) {
                ansList.remove(root);
            } else {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;

                }
            }
        }

        dfs(root.left, deleteSet, root, true);
        dfs(root.right, deleteSet, root, false);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ansList = new ArrayList<>();
        ansList.add(root);

        Set<Integer> set = new HashSet<>();
        for (int num: to_delete) {
            set.add(num);
        }

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (set.contains(root.val)) {
                return ansList;
            } else {
                ansList.add(root);
                return ansList;
            }
        }

        dfs(root, set, null, false);

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
