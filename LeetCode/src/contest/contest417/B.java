package contest.contest417;

import java.util.*;

public class B {

    private List<Integer>[] getIndexListArr(char[] arr) {
        List<Integer>[] indexListArr = new ArrayList[26];
        Arrays.setAll(indexListArr, value -> new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            indexListArr[arr[i] - 'a'].add(i);
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

    public int countOfSubstrings(String word, int k) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        List<Integer>[] indexListArr = getIndexListArr(arr);
        int[][] preCountArr = new int[26][len];
        preCountArr[arr[0] - 'a'][0] = 1;
        Map<Integer, int[]> map = new HashMap<>();
        int[] fyPreCountArr = new int[len];
        if (isYY(arr[0])) {
            map.put(0, new int[]{0, 0});
        } else {
            map.put(1, new int[]{0, 0});
            fyPreCountArr[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (isYY(arr[i])) {
               int[] indexArr = map.get(fyPreCountArr[i - 1]);
               indexArr[1] = i;
                fyPreCountArr[i] = fyPreCountArr[i - 1];
            } else {
                map.put(fyPreCountArr[i - 1] + 1, new int[]{i, i});
                fyPreCountArr[i] = fyPreCountArr[i - 1] + 1;
            }
            for (int j = 0; j < 26; j++) {
                if (arr[i] - 'a' == j) {
                    preCountArr[j][i] = preCountArr[j][i - 1] + 1;
                } else {
                    preCountArr[j][i] = preCountArr[j][i - 1];
                }
            }
        }

        int ans = 0;
        char[] yyArr = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < len; i++) {
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
                List<Integer> indexList = indexListArr[c - 'a'];
                int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(indexList, i);
                if (firstBiggerOrEqualIdx == -1) {
                    isFound = false;
                    break;
                }

                maxIdx = Math.max(maxIdx, indexList.get(firstBiggerOrEqualIdx));
            }

            if (!isFound) {
                continue;
            }

            int sIdx = Math.max(startIdx, maxIdx);
            ans += Math.max(0, endIdx - sIdx + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new B().countOfSubstrings("aeiou", 0));
        System.out.println(new B().countOfSubstrings("cuiaeo", 0));
    }

}
