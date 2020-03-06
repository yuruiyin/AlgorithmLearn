package problem501_600;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem508 {

    private Map<Integer, Integer> countMap;

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + getSum(root.left) + getSum(root.right);
        countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        countMap = new HashMap<>();
        getSum(root);
        int maxCount = 0;
        for (Integer sum : countMap.keySet()) {
            maxCount = Math.max(maxCount, countMap.get(sum));
        }

        List<Integer> ansList = new ArrayList<>();
        for (Integer sum : countMap.keySet()) {
            if (countMap.get(sum) == maxCount) {
                ansList.add(sum);
            }
        }

        int size = ansList.size();
        int[] ansArr = new int[size];
        for (int i = 0; i < size; i++) {
            ansArr[i] = ansList.get(i);
        }
        return ansArr;
    }

}
