package problem1301_1400;

import java.util.*;

public class Problem1307 {

    private String[] words;
    private String result;
    private List<Character> charList;
    private int charSize;
    private boolean[] nonZero;


    // 判断当前映射组合能否让方程可解。sum(word[i]) = result
    private boolean isMatch(int[] map) {
        int carry = 0;
        for (int i = 0; i < result.length(); i++) {
            int sum = carry;
            for (String word : words) {
                if (word.length() > i) {
                    sum += map[word.charAt(i) - 'A'];
                }
            }

            if (sum % 10 != map[result.charAt(i) - 'A']) {
                return false;
            }

            carry = sum / 10;
        }

        return carry == 0;
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

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isSolvable(String[] wordArr, String res) {
        this.words = new String[wordArr.length];
        for (int i = 0; i < wordArr.length; i++) {
            this.words[i] = reverse(wordArr[i]);
        }
        this.result = reverse(res);
        int resLen = result.length();
        Set<Character> set = new HashSet<>();
        nonZero = new boolean[26];
        for (String word : words) {
            if (word.length() > resLen) {
                return false;
            }

            if (word.length() > 1) {
                nonZero[word.charAt(word.length() - 1) - 'A'] = true;
            }
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }

        if (resLen > 1) {
            nonZero[result.charAt(resLen - 1) - 'A'] = true;
        }
        for (char c : result.toCharArray()) {
            set.add(c);
        }

        charList = new ArrayList<>(set);
        charSize = charList.size();

        int[] map = new int[26];
        Arrays.fill(map, -1);
        return backTrack(0, new boolean[10], map);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1307().isSolvable(new String[]{"A", "B"}, "A"));
    }

}
