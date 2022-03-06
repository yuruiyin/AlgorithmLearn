package doubleContest.round64;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/30
 */
public class C {

    private int findFirstBiggerOrEqual(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target <= list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return list.get(mid);
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findLastSmallerOrEqual(List<Integer> list, int target) {
        int len = list.size();
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal <= target) {
                if (mid == len - 1 || list.get(mid + 1) > target) {
                    return midVal;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int[] preStarCountArr = new int[len];
        preStarCountArr[0] = arr[0] == '*' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            preStarCountArr[i] = preStarCountArr[i - 1] + (arr[i] == '*' ? 1 : 0);
        }

        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] == '|') {
                indexList.add(i);
            }
        }

        int[] ansArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(indexList, l);
            int lastSmallerOrEqualIdx = findLastSmallerOrEqual(indexList, r);
            if (firstBiggerOrEqualIdx != -1 && lastSmallerOrEqualIdx != -1 && lastSmallerOrEqualIdx > firstBiggerOrEqualIdx) {
                ansArr[i] = preStarCountArr[lastSmallerOrEqualIdx] - preStarCountArr[firstBiggerOrEqualIdx];
            } else {
                ansArr[i] = 0;
            }
        }

        return ansArr;

    }

}
