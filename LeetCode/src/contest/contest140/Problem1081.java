package contest.contest140;

import java.util.ArrayList;
import java.util.List;

public class Problem1081 {

    private String ans;
    private List<Integer>[] charToIndexListMap;
    private List<Character> charList;

    private int findFirstBiggerByBinarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target < list.get(mid)) {
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

    private boolean backTrack(boolean[] visited, List<Character> tmpList, int from) {

        int charSize = charList.size();
        if (tmpList.size() == charSize) {
            StringBuilder sb = new StringBuilder();
            for (Character c: tmpList) {
                sb.append(c);
            }
            ans = sb.toString();
            return true;
        }

        for (int i = 0; i < charSize; i++) {
            char c = charList.get(i);
            if (visited[c - 'a']) {
                continue;
            }

            List<Integer> indexList = charToIndexListMap[c - 'a'];
            int nextIndex = findFirstBiggerByBinarySearch(indexList, from);
            if (nextIndex == -1) {
                return false;
            }

            int index = indexList.get(nextIndex);

            visited[c - 'a'] = true;
            tmpList.add(c);
            boolean isFound = backTrack(visited, tmpList, index);
            if (isFound) {
                return true;
            }
            tmpList.remove(tmpList.size() - 1);
            visited[c - 'a'] = false;
        }

        return false;
    }

    public String smallestSubsequence(String text) {
        // 回溯
        charToIndexListMap = new ArrayList[26];
        char[] arr = text.toCharArray();
        int len = arr.length;

        for (int i = 0; i < 26; i++) {
            charToIndexListMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            charToIndexListMap[c - 'a'].add(i);
        }

        charList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (!charToIndexListMap[i].isEmpty()) {
                charList.add((char) (i + 'a'));
            }
        }

        backTrack(new boolean[26], new ArrayList<>(), -1);

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1081().smallestSubsequence("abcd"));
    }
    
}
