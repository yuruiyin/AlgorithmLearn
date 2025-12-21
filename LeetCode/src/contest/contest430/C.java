package contest.contest430;

import java.util.*;

public class C {

    public long numberOfSubsequences(int[] nums) {
        int len = nums.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int value = nums[i] * nums[j];
                if (!map.containsKey(value)) {
                    map.put(value, new ArrayList<>());
                }
                map.get(value).add(new int[]{i, j});
            }
        }

        long ans = 0;
        for (int key : map.keySet()) {
            List<int[]> posList = map.get(key);
            int size = posList.size();
            if (size < 2) {
                continue;
            }
            Collections.sort(posList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for (int i = 0; i < size - 1; i++) {
                int[] pos1 = posList.get(i);
                int p = pos1[0];
                int r = pos1[1];
                for (int j = i + 1; j < size; j++) {
                    int[] pos2 = posList.get(j);
                    int q = pos2[0];
                    int s = pos2[1];
                    if (q - p > 1 && r - q > 1 && s - r > 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;

//        for (int p = 0; p < len - 6; p++) {
//            for (int r = p + 4; r < len - 2; r++) {
//                int value = nums[p] * nums[r];
//
//            }
//        }
    }

}
