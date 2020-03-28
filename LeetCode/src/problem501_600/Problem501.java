package problem501_600;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem501
 *
 * @author: yry
 * @date: 2020/3/28
 */
public class Problem501 {

    private void dfs(TreeNode root, Map<Integer, Integer> countMap) {
        if (root == null) {
            return;
        }

        countMap.put(root.val, countMap.getOrDefault(root.val, 0) + 1);
        dfs(root.left, countMap);
        dfs(root.right, countMap);
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        dfs(root, countMap);

        List<Integer> list = new ArrayList<>();
        int maxCount = 0;
        for (Integer val : countMap.keySet()) {
            maxCount = Math.max(maxCount,countMap.get(val));
        }

        for (Integer val : countMap.keySet()) {
            if (countMap.get(val) == maxCount) {
                list.add(val);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
