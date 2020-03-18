package problem501_600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem554
 *
 * @author: yry
 * @date: 2020/3/16
 */
public class Problem554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> preSumCountMap = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            // 遍历每一行
            int preSum = 0;
            List<Integer> curRowList = wall.get(i);
            for (int j = 0; j < curRowList.size() - 1; j++) {
                preSum += curRowList.get(j);
                preSumCountMap.put(preSum, preSumCountMap.getOrDefault(preSum, 0) + 1);
            }
        }

        int maxCount = 0;
        for (Integer preSum: preSumCountMap.keySet()) {
            maxCount = Math.max(maxCount, preSumCountMap.get(preSum));
        }

        return wall.size() - maxCount;
    }

}
