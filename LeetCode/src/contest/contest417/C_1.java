package contest.contest417;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class C_1 {

    private LinkedList<Integer>[] getIndexListArr(char[] arr, boolean[] yyVisited) {
        LinkedList<Integer>[] indexListArr = new LinkedList[26];
        for (int i = 0; i < arr.length; i++) {
            if (yyVisited[arr[i] - 'a']) {
                int idx = arr[i] - 'a';
                if (indexListArr[idx] == null) {
                    indexListArr[idx] = new LinkedList<>();
                }
                indexListArr[idx].addLast(i);
            }
        }
        return indexListArr;
    }

    public long countOfSubstrings(String word, int k) {
        boolean[] yyVisited = new boolean[26];
        char[] yyArr = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char c : yyArr) {
            yyVisited[c - 'a'] = true;
        }
        char[] arr = word.toCharArray();
        int len = arr.length;
        LinkedList<Integer>[] indexListArr = getIndexListArr(arr, yyVisited);
        Map<Integer, int[]> map = new HashMap<>();
        int[] fyPreCountArr = new int[len];
        if (yyVisited[arr[0] - 'a']) {
            map.put(0, new int[]{0, 0});
        } else {
            map.put(1, new int[]{0, 0});
            fyPreCountArr[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (yyVisited[arr[i] - 'a']) {
                int[] indexArr = map.get(fyPreCountArr[i - 1]);
                indexArr[1] = i;
                fyPreCountArr[i] = fyPreCountArr[i - 1];
            } else {
                map.put(fyPreCountArr[i - 1] + 1, new int[]{i, i});
                fyPreCountArr[i] = fyPreCountArr[i - 1] + 1;
            }
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            if (fyPreCountArr[len - 1] - (i == 0 ? 0 : fyPreCountArr[i - 1]) < k) {
                break;
            }
            int[] kIdxArr = i == 0 ? map.get(k) : map.get(k + fyPreCountArr[i - 1]);
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
                if (indexList == null || indexList.isEmpty()) {
                    isFound = false;
                    break;
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
                break;
            }

            int sIdx = Math.max(startIdx, maxIdx);
            ans += Math.max(0, endIdx - sIdx + 1);
        }

        return ans;
    }

}
