package contest.contest296;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, List<Integer>> indexListMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!indexListMap.containsKey(nums[i])) {
                indexListMap.put(nums[i], new ArrayList<>());
            }
            indexListMap.get(nums[i]).add(i);
        }

        for (int[] oper: operations) {
            int from = oper[0];
            int to = oper[1];
            indexListMap.put(to, indexListMap.get(from));
            indexListMap.remove(from);
        }

        int[] ansArr = new int[len];
        for (int key : indexListMap.keySet()) {
            List<Integer> indexList = indexListMap.get(key);
            for (int idx: indexList) {
                ansArr[idx] = key;
            }
        }
        return ansArr;
    }

}
