package contest.contest417;

import java.util.*;

public class C {

    private LinkedList<Integer>[] getIndexListArr(char[] arr) {
        LinkedList<Integer>[] indexListArr = new LinkedList[26];
        Arrays.setAll(indexListArr, value -> new LinkedList<>());
        for (int i = 0; i < arr.length; i++) {
            indexListArr[arr[i] - 'a'].addLast(i);
        }
        return indexListArr;
    }

    private boolean isYY(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private int findFirstBiggerOrEqual(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target <= list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public long countOfSubstrings(String word, int k) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        LinkedList<Integer>[] indexListArr = getIndexListArr(arr);
        int[][] intervalMap = new int[len + 1][2];
        int[] fyPreCountArr = new int[len];
        if (isYY(arr[0])) {
            intervalMap[0] = new int[]{0, 0};
        } else {
            intervalMap[1] = new int[]{0, 0};
            fyPreCountArr[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (isYY(arr[i])) {
                int[] indexArr = intervalMap[fyPreCountArr[i - 1]];
                indexArr[1] = i;
                fyPreCountArr[i] = fyPreCountArr[i - 1];
            } else {
                intervalMap[fyPreCountArr[i - 1] + 1] = new int[]{i, i};
                fyPreCountArr[i] = fyPreCountArr[i - 1] + 1;
            }
        }

        long ans = 0;
        char[] yyArr = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < len; i++) {
            int[] kIdxArr;
            if (i == 0) {
                kIdxArr = intervalMap[k];
            } else {
                int count = k + fyPreCountArr[i - 1];
                if (count >= len) {
                    continue;
                }
                kIdxArr = intervalMap[count];
            }

            if (kIdxArr == null) {
                continue;
            }

            int startIdx = kIdxArr[0];
            int endIdx = kIdxArr[1];
            //寻找第一个 >= i 的idx
            int maxIdx = -1;
            boolean isFound = true;
            for (char c : yyArr) {
                LinkedList<Integer> indexList = indexListArr[c - 'a'];
                if (indexList.isEmpty()) {
                    isFound = false;
                    continue;
                }
                maxIdx = Math.max(maxIdx, indexList.getFirst());
                while (!indexList.isEmpty()) {
                    if (indexList.getFirst() <= i) {
                        indexList.pollFirst();
                    } else {
                        break;
                    }
                }
            }

            if (!isFound) {
                continue;
            }

            int sIdx = Math.max(startIdx, maxIdx);
            ans += Math.max(0, endIdx - sIdx + 1);
        }

        return ans;
    }

}
