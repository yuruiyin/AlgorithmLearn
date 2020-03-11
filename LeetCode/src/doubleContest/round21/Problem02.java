package doubleContest.round21;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

    private int findFirstBiggerOrEqual(List<Integer> list, long target) {
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

    public int findTheLongestSubstring(String s) {
        List<Integer>[] indexListMap = new ArrayList[26];
        char[] arr = s.toCharArray();
        int len = arr.length;

        boolean[] visited = new boolean[26];
        visited[0] = true;
        visited['e' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['o' - 'a'] = true;
        visited['u' - 'a'] = true;

        for (int i = 0; i < len; i++) {
            int index = arr[i] - 'a';
            if (visited[index]) {
                if (indexListMap[index] == null) {
                    indexListMap[index] = new ArrayList<>();
                }

                indexListMap[index].add(i);
            }
        }

        int[][] preCountArr = new  int[len][26];
        char[] charArr = new char[] {
            'a', 'e', 'i', 'o', 'u'
        };

        for (int j = 0; j < 5; j++) {
            char c = charArr[j];
            for (int i = 0; i < len; i++) {
                if (c == arr[i]) {
                    preCountArr[i][c - 'a'] = i == 0 ? 1 : preCountArr[i-1][c - 'a'] + 1;
                } else {
                    if (i > 0) {
                        preCountArr[i][c - 'a'] = preCountArr[i-1][c - 'a'];
                    }
                }
            }
        }

        int ansMax = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i + 1 <= ansMax) {
                break;
            }
            int from = 0;
            while (true) {
                boolean isOk = true;
                for (Character c : charArr) {
                    int count;
                    if (from == 0) {
                        count = preCountArr[i][c - 'a'];
                    } else {
                        count = preCountArr[i][c - 'a'] - preCountArr[from - 1][c - 'a'];
                    }

                    if (count % 2 != 0) {
                        isOk = false;
                        int firstBiggerIndex = findFirstBiggerOrEqual(indexListMap[c - 'a'], from);
                        if (firstBiggerIndex != -1) {
                            from = firstBiggerIndex + 1;
                        }
                        break;
                    }
                }

                if (isOk) {
                    ansMax = Math.max(ansMax, i - from + 1);
                    break;
                }

                if (i - from + 1 <= ansMax) {
                    break;
                }
            }

        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem02().findTheLongestSubstring("eleetminicoworoep"));
    }

}
