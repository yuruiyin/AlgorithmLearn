package contest.contest235;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/4
 */
public class B {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ansArr = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            if (!map.containsKey(id)) {
                map.put(id, new HashSet<>());
            }
            map.get(id).add(time);
        }

        for (Integer id : map.keySet()) {
            Set<Integer> times = map.get(id);
            ansArr[times.size() - 1]++;
        }

        return ansArr;
    }

}
