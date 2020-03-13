package problem101_200;

import java.util.HashSet;
import java.util.List;

public class Problem127_1 {

    private int bfs(HashSet<String> startSet, HashSet<String> endSet, HashSet<String> dict, int level) {
        if (startSet.isEmpty()) {
            return 0;
        }

        if (startSet.size() > endSet.size()) {
            return bfs(endSet, startSet, dict, level);
        }

        dict.removeAll(startSet); // 已经访问过就不要再访问了。
        HashSet<String> nextStartSet = new HashSet<>();
        for (String start : startSet) {
            char[] arr = start.toCharArray();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                // 每一位替换
                char tmp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }

                    arr[i] = c;
                    String newWord = new String(arr);
                    if (!dict.contains(newWord)) {
                        continue;
                    }

                    if (endSet.contains(newWord)) {
                        return level + 1;
                    }

                    nextStartSet.add(newWord);
                }
                arr[i] = tmp; // 复原
            }
        }

        return bfs(nextStartSet, endSet, dict, level + 1);
    }

    // 双向bfs，每次bfs都从当前层个数少的端出发。方向会出现交替的现象。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> dict = new HashSet<>(wordList);
        startSet.add(beginWord);
        endSet.add(endWord);
        if (!dict.contains(endWord)) {
            return 0;
        }
        return bfs(startSet, endSet, dict, 1);
    }

}
