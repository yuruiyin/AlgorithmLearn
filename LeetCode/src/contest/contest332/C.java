package contest.contest332;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class C {

    class Interval {
        int l;
        int r;
        Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int qLen = queries.length;
        int[][] ansArr = new int[qLen][2];
        char[] arr = s.toCharArray();
        int sLen = arr.length;

        Map<Integer, Interval> map = new HashMap<>();
        int firstZeroIdx = -1;
        for (int l = 0; l < sLen; l++) {
            if (arr[l] == '0') {
                if (firstZeroIdx == -1) {
                    firstZeroIdx = l;
                }
                continue;
            }
            int value = 0;
            for (int r = l; r < Math.min(sLen, l + 32); r++) {
                value += (arr[r] - '0');
                if (!map.containsKey(value)) {
                    map.put(value, new Interval(l, r));
                }
                value <<= 1;
            }
        }

        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int first = q[0];
            int second = q[1];
            int val = first ^ second;
            if (val == 0) {
                ansArr[i] = new int[]{firstZeroIdx, firstZeroIdx};
                continue;
            }
            if (!map.containsKey(val)) {
                ansArr[i] = new int[]{-1, -1};
                continue;
            }
            Interval interval = map.get(val);
            ansArr[i] = new int[]{interval.l, interval.r};
        }
        return ansArr;
    }

}
