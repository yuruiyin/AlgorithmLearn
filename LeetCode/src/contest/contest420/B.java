package contest.contest420;

import java.util.Arrays;
import java.util.LinkedList;

public class B {

    public int numberOfSubstrings(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
//        int[][] preCountArr = new int[len][26];
//        preCountArr[0][arr[0] - 'a'] = 1;
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < 26; j++) {
//                if (j == arr[i] - 'a') {
//                    preCountArr[i][j] = preCountArr[i - 1][j] + 1;
//                } else {
//                    preCountArr[i][j] = preCountArr[i - 1][j];
//                }
//            }
//        }
//
        LinkedList<Integer>[] queue = new LinkedList[26];
        Arrays.setAll(queue, value -> new LinkedList<>());
        for (int i = 0; i < len; i++) {
            queue[arr[i] - 'a'].addLast(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int minIdx = len;
            for (int j = 0; j < 26; j++) {
                LinkedList<Integer> indexList = queue[j];
                if (indexList.size() < k) {
                    continue;
                }

                int idx = indexList.get(k - 1);
                minIdx = Math.min(minIdx, idx);
            }
            ans += len - minIdx;
            queue[arr[i] - 'a'].pollFirst();
        }

        return ans;
    }


}
