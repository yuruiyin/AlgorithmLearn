package contest.contest169;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem02_1 {

    private void dfs(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        dfs(root.left, ansList);
        ansList.add(root.val);
        dfs(root.right, ansList);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> ansList = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int index1, index2;
        for (index1 = 0, index2 = 0; index1 < size1 && index2 < size2;) {
            int num1 = list1.get(index1);
            int num2 = list2.get(index2);
            if (num1 < num2) {
                ansList.add(num1);
                index1++;
            } else {
                ansList.add(num2);
                index2++;
            }
        }

        while (index1 < size1) {
            ansList.add(list1.get(index1++));
        }

        while (index2 < size2) {
            ansList.add(list2.get(index2++));
        }

        return ansList;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ansList1 = new ArrayList<>();
        List<Integer> ansList2 = new ArrayList<>();
        dfs(root1, ansList1);
        dfs(root2, ansList2);

        return merge(ansList1, ansList2);
    }

}
