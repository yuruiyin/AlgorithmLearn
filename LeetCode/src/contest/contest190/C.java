package contest.contest190;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/24
 */
public class C {

    private int ansCount = 0;

    private boolean isOk(List<Integer> tmpList) {
        int size = tmpList.size();
        int[] countArr = new int[10];
        for (Integer num : tmpList) {
            countArr[num]++;
        }

        int oddCount = 0;
        for (int i = 1; i <= 9; i++) {
            if (countArr[i] % 2 == 1) {
                oddCount++;
            }
        }

        return size % 2 == 0 && oddCount == 0 || size % 2 == 1 && oddCount == 1;
    }

    private void dfs(TreeNode root, List<Integer> tmpList) {
        if (root == null) {
            return;
        }

        tmpList.add(root.val);
        if (root.left == null && root.right == null) {
            if (isOk(tmpList)) {
                ansCount++;
            }
            tmpList.remove(tmpList.size() - 1);
            return;
        }

        dfs(root.left, tmpList);
        dfs(root.right, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new ArrayList<>());
        return ansCount;
    }

}
