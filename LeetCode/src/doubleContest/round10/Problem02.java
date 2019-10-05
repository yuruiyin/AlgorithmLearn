package doubleContest.round10;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     private void getList(TreeNode root, List<Integer> list) {
         if (root == null) {
             return;
         }

         list.add(root.val);

         if (root.left != null) {
             getList(root.left, list);
         }

         if (root.right != null) {
             getList(root.right, list);
         }
     }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getList(root1, list1);
        getList(root2, list2);

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) + list2.get(j) == target) {
                    return true;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
