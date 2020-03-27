package problem901_1000;

import common.TreeNode;

import java.util.*;

/**
 * Problem971
 *
 * @author: yry
 * @date: 2020/3/26
 */
public class Problem971 {

    private Map<TreeNode, int[]> map;

    private int calcCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = calcCount(root.left);
        int rightCount = calcCount(root.right);
        map.put(root, new int[]{leftCount, rightCount});
        return leftCount + rightCount + 1;
    }

    private List<Integer> dfs(TreeNode root, int start, int end, int[] voyage) {
        if (root == null) {
            return start > end ? new ArrayList<>() : null;
        }

        if (root.val != voyage[start]) {
            return null;
        }

        List<Integer> ansList = new ArrayList<>();
        int[] countArr = map.get(root);
        int leftStart = start + 1;
        int leftEnd = start + countArr[0];
        int rightStart = start + countArr[0] + 1;
        int rightEnd = end;
        if (root.left != null && root.left.val != voyage[start + 1]) {
            // 需要翻转
            ansList.add(root.val);
            leftStart = start + countArr[1] + 1;
            leftEnd = end;
            rightStart = start + 1;
            rightEnd = start + countArr[1];
        }

        List<Integer> rightList = dfs(root.right, rightStart, rightEnd, voyage);
        if (rightList == null) {
            return null;
        }
        List<Integer> leftList = dfs(root.left, leftStart, leftEnd, voyage);
        if (leftList == null) {
            return null;
        }

        ansList.addAll(leftList);
        ansList.addAll(rightList);
        return ansList;
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        // 先求每个节点左右的子节点个数
        map = new HashMap<>();
        calcCount(root);

        List<Integer> ansList = dfs(root, 0, voyage.length - 1, voyage);
        return ansList == null ? new ArrayList<>(Arrays.asList(-1)) : ansList;
    }

}
