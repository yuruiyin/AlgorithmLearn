package doubleContest.round20;

import java.util.ArrayList;
import java.util.List;

public class Problem03 {

    private int findFirstBiggerByBinarySearch(List<Integer> list, int target) {
        if (list == null) {
            return -1;
        }
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target < list.get(mid)) {
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

    public int numberOfSubstrings(String s) {
        int len = s.length();
        List<Integer>[] indexListArr = new ArrayList[3];
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (indexListArr[arr[i] - 'a'] == null) {
                indexListArr[arr[i] - 'a'] = new ArrayList<>();
            }

            indexListArr[arr[i] - 'a'].add(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'a') {
                int bNextIndex = findFirstBiggerByBinarySearch(indexListArr[1], i);
                if (bNextIndex == -1) {
                    return ans;
                }

                int cNextIndex = findFirstBiggerByBinarySearch(indexListArr[2], i);
                if (cNextIndex == -1) {
                    return ans;
                }

                int maxIndex = Math.max(bNextIndex, cNextIndex);
                ans += len - maxIndex;
            } else if (arr[i] == 'b') {
                int aNextIndex = findFirstBiggerByBinarySearch(indexListArr[0], i);
                if (aNextIndex == -1) {
                    return ans;
                }

                int cNextIndex = findFirstBiggerByBinarySearch(indexListArr[2], i);
                if (cNextIndex == -1) {
                    return ans;
                }

                int maxIndex = Math.max(aNextIndex, cNextIndex);
                ans += len - maxIndex;
            } else {
                int aNextIndex = findFirstBiggerByBinarySearch(indexListArr[0], i);
                if (aNextIndex == -1) {
                    return ans;
                }

                int bNextIndex = findFirstBiggerByBinarySearch(indexListArr[1], i);
                if (bNextIndex == -1) {
                    return ans;
                }

                int maxIndex = Math.max(aNextIndex, bNextIndex);
                ans += len - maxIndex;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.print(new Problem03().numberOfSubstrings("abcabc"));
    }

}
