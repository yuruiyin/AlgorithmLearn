package contest.contest349;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class D {

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] nums[] = new int[nums1.length][], result = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (o, p) -> p[0] - o[0]);
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (o, p) -> queries[p][0] - queries[o][0]);
        TreeMap<Integer, Integer> map = new TreeMap<>(Map.of(0, Integer.MAX_VALUE, Integer.MAX_VALUE, -1));
        for (int i = 0, j = 0; i < queries.length; i++) {
            for (; j < nums.length && nums[j][0] >= queries[index[i]][0]; j++) {
                if (map.ceilingEntry(nums[j][1]).getValue() < nums[j][0] + nums[j][1]) {
                    while (map.floorEntry(nums[j][1]).getValue() <= nums[j][0] + nums[j][1]) {
                        map.remove(map.floorKey(nums[j][1]));
                    }
                    map.put(nums[j][1], nums[j][0] + nums[j][1]);
                }
            }
            result[index[i]] = map.ceilingEntry(queries[index[i]][1]).getValue();
        }
        return result;
    }

}
