package problem1101_1200;

import java.util.ArrayList;
import java.util.List;

public class Problem1163 {

    private StringBuilder ansSb;

    private void dfs(String str, List<Integer> indexList) {
        if (indexList.isEmpty()) {
            return;
        }

        char maxChar = 'a';
        int size = indexList.size();

        for (int i = 0; i < size; i++) {
            char c = str.charAt(indexList.get(i));
            if (c > maxChar) {
                maxChar = c;
            }
        }

        // 最大字符的坐标
        List<Integer> maxCharIndexList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = indexList.get(i);
            char c = str.charAt(index);
            if (c == maxChar) {
                maxCharIndexList.add(index);
            }
        }

        if (maxCharIndexList.size() == 1) {
            // 如果最大字符就一个，直接返回到字符串尾部的即可
            for (int i = maxCharIndexList.get(0); i < str.length(); i++) {
                ansSb.append(str.charAt(i));
            }
            return;
        }

        ansSb.append(maxChar);

        List<Integer> newIndexList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = indexList.get(i);
            char c = str.charAt(index);
            if (c == maxChar && index != str.length() - 1) {
                newIndexList.add(index + 1);
            }
        }

        dfs(str, newIndexList);
    }

    public String lastSubstring(String s) {
        ansSb = new StringBuilder();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                // 去重 ,如aaaab，只要记录0,4索引即可。
                continue;
            }
            indexList.add(i);
        }
        dfs(s, indexList);
        return ansSb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem1163().lastSubstring("abab"));
        System.out.println(new Problem1163().lastSubstring("leetcode"));
        System.out.println(new Problem1163().lastSubstring("ttttt"));
        System.out.println(new Problem1163().lastSubstring("tttta"));
    }
}
