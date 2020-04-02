package problem601_700;

import common.TreeNode;

import java.util.*;

/**
 * Problem652
 *
 * @author: yry
 * @date: 2020/4/2
 */
public class Problem652 {

    private List<TreeNode> ansList;
    private Set<TreeNode> visited;
    private Map<TreeNode, Integer> countMap;
    private List<TreeNode>[] sameCountNodeListArr;

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }

        if (root2 == null) {
            return false;
        }

        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    private void rec(TreeNode cur) {
        if (cur == null) {
            return;
        }

        int cutTreeCount = countMap.get(cur);
        List<TreeNode> sameCountNodeList = sameCountNodeListArr[cutTreeCount];
        boolean hasSame = false;
        for (TreeNode node : sameCountNodeList) {
            if (!visited.contains(node) && node != cur && isSame(node, cur)) {
                visited.add(node);
                hasSame = true;
            }
        }

        if (hasSame) {
            ansList.add(cur);
            visited.add(cur);
        }

        rec(cur.left);
        rec(cur.right);
    }

    private int calcCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = calcCount(root.left) +  calcCount(root.right) + 1;
        countMap.put(root, count);
        return count;
    }

    private void createSameCountNodeListArr() {
        sameCountNodeListArr = new ArrayList[10001];
        for (TreeNode node : countMap.keySet()) {
            int count = countMap.get(node);
            if (sameCountNodeListArr[count] == null) {
                sameCountNodeListArr[count] = new ArrayList<>();
            }
            sameCountNodeListArr[count].add(node);
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ansList = new ArrayList<>();
        visited = new HashSet<>();
        countMap = new HashMap<>();
        calcCount(root);
        createSameCountNodeListArr();
        rec(root);
        return ansList;
    }

}
