package contest.contest169;

import java.util.*;

public class Problem04 {

    private String[] words;
    private String result;
    private List<Character> charList;
    private int charSize;
    private boolean[] nonZero;

    // 判断当前映射组合能否让方程可解。sum(word[i]) = result
    private boolean isMatch(int[] map) {
        int sum = 0;
        for (String word: words) {
            int tmp = 0;
            for (char c : word.toCharArray()) {
                tmp *= 10;
                tmp += map[c - 'A'];
            }
            sum += tmp;
        }

        int resultValue = 0;
        for (char c : result.toCharArray()) {
            resultValue *= 10;
            resultValue += map[c - 'A'];
        }

        return sum == resultValue;
    }

    private boolean backTrack(int from, boolean[] visited, int[] map) {
        if (from == charSize) {
            return isMatch(map);
        }

        char curChar = charList.get(from);
        for (int i = 0; i <= 9; i++) {
            if (i == 0 && nonZero[curChar - 'A'] || visited[i]) {
                continue;
            }

            visited[i] = true;
            map[curChar - 'A'] = i;
            boolean isMatch = backTrack(from + 1, visited, map);
            if (isMatch) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        int resLen = result.length();
        Set<Character> set = new HashSet<>();
        nonZero = new boolean[26];
        for (String word: words) {
            if (word.length() > resLen) {
                return false;
            }

            nonZero[word.charAt(0) - 'A'] = true;
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }

        nonZero[result.charAt(0) - 'A'] = true;
        for (char c : result.toCharArray()) {
            set.add(c);
        }

        charList = new ArrayList<>(set);
        charSize = charList.size();

        int[] map = new int[26];
        Arrays.fill(map, -1);
        return backTrack(0, new boolean[10], map);
    }

}
