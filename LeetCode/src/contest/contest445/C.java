package contest.contest445;

import java.util.*;

public class C {

    private void rec(List<Character> charList, StringBuilder path, List<String> result, int k, boolean[] visited) {
        if (result.size() >= k) {
            return;
        }

        if (path.length() == charList.size()) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < charList.size(); i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && charList.get(i) == charList.get(i - 1) && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            path.append(charList.get(i));
            rec(charList, path, result, k, visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }

    private String getAns(List<Character> halfCharList, int k, String mid) {
        List<String> halfPermutations = new ArrayList<>();
        boolean[] visited = new boolean[halfCharList.size()];
        Collections.sort(halfCharList);
        rec(halfCharList, new StringBuilder(), halfPermutations, k, visited);

        if (k > halfPermutations.size()) {
            return "";
        }

        String half = halfPermutations.get(k - 1);
        return half + mid + new StringBuilder(half).reverse();
    }

    public String smallestPalindrome(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        List<Character> halfCharList = new ArrayList<>();
        String mid = "";

        for (char c : countMap.keySet()) {
            int freq = countMap.get(c);
            if (freq % 2 == 1) {
                if (!mid.isEmpty()) {
                    return "";
                }

                mid = String.valueOf(c);
            }

            for (int i = 0; i < freq / 2; i++) {
                halfCharList.add(c);
            }
        }

        return getAns(halfCharList, k, mid);
    }
}
