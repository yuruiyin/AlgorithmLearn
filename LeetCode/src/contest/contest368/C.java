package contest.contest368;

import java.util.*;

public class C {

    private static Map<Long, Integer> memoMap = new HashMap<>();

    /**
     * 求ax + by = v中 x + y的最小值
     * 二分 然后 求二元1次方程
     */
    private int getCount(long a, long b, long v) {
        long key = a * 100000 + v;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }
        long l = 1;
        long r = v / a + 1;
        long min = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) >>> 1L;
            // x + y = mid
            if ((v - a * mid) % (b - a) == 0) {
                long y = (v - a * mid) / (b - a);
                long x = mid - y;
                if (x >= 0 && y >= 0) {
                    min = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                l = mid + 1;
            }
        }
        int res = min == Integer.MAX_VALUE ? -1 : (int) min;
        memoMap.put(key, res);
        return res;
    }

    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        if (countMap.size() == 1) {
            return 1;
        }

        LinkedList<Integer> countList = new LinkedList<>();
        int minCount = Integer.MAX_VALUE;
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            countList.add(count);
            minCount = Math.min(minCount, count);
        }

        int l = 1;
        int r = minCount;
        int size = countList.size();
        int ansMinGroupCount = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            int groupCount = 0;
            boolean isOk = true;
            for (int i = 0; i < size; i++) {
                int count = getCount(mid, mid + 1, countList.get(i));
                if (count == -1) {
                    isOk = false;
                    break;
                }
                groupCount += count;
            }
            if (isOk) {
                ansMinGroupCount = groupCount;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ansMinGroupCount;
    }

    public static void main(String[] args) {
        System.out.println(new C().minGroupsForValidAssignment(new int[]{
                2, 3, 3, 3, 2, 3, 2, 3, 2
        }));
    }

}
