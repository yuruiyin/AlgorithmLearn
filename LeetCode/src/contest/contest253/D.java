package contest.contest253;

import java.util.TreeMap;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/8
 */
public class D {

    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = arr.length;
        int[] ansArr = new int[len];
        ansArr[0] = 1;
        map.put(arr[0], 1);
        for (int i = 1; i < len; i++) {
            Integer pre = map.floorKey(arr[i]);
            if (pre == null) {
                ansArr[i] = 1;
                map.put(arr[i], 1);
            } else {
                ansArr[i] = map.get(pre) + 1;
                while (map.ceilingKey(arr[i]) != null) {
                    int ceilKey = map.ceilingKey(arr[i]);
                    if (map.get(ceilKey) <= ansArr[i]) {
                        map.remove(ceilKey);
                    } else {
                        break;
                    }
                }
                map.put(arr[i], ansArr[i]);
            }
        }
        return ansArr;
    }

}
