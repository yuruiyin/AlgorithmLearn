package problem201_300;

import java.util.*;

public class Problem269 {

    private static final int MAX_CHAR_COUNT = 26;

    public String alienOrder(String[] words) {
        // 先将所有字符放到一个set中
        Set<Character> charSet = new HashSet<>();
        for (String word: words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                charSet.add(word.charAt(i));
            }
        }

        List<Character>[] adj = new ArrayList[MAX_CHAR_COUNT];

        for (int i = 0; i < MAX_CHAR_COUNT; i++) {
            adj[i] = new ArrayList<>();
        }

        int wordSize = words.length;

        for (int i = 1; i < wordSize; i++) {
            int curWordLen = words[i].length();
            int prevWordLen = words[i-1].length();
            int minWordLen = Math.min(curWordLen, prevWordLen);
            for (int j = 0; j < minWordLen; j++) {
                char curChar = words[i].charAt(j);
                char prevChar = words[i-1].charAt(j);
                if (curChar == prevChar) {
                    continue;
                }

                adj[prevChar - 'a'].add(curChar);
                break;
            }
        }

        // 计算每个字符的入度
        int[] inDegree = new int[MAX_CHAR_COUNT];
        for (int i = 0; i < MAX_CHAR_COUNT; i++) {
            if (adj[i].isEmpty()) {
                continue;
            }

            for (int j = 0; j < adj[i].size(); j++) {
                char w = adj[i].get(j);
                inDegree[w - 'a']++;
            }
        }

        // 将入度为0的字符添加到队列中
        LinkedList<Character> queue = new LinkedList<>();
        for (Character c: charSet) {
            if (inDegree[c - 'a'] == 0) {
                queue.addLast(c);
            }
        }

        List<Character> charList = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 将队列中所有的都出队
            List<Character> tmpChars = new ArrayList<>();
            while (!queue.isEmpty()) {
                tmpChars.add(queue.removeFirst());
            }

            charList.addAll(tmpChars);

            for (Character c: tmpChars) {
                int curCharIndex = c - 'a';
                // 遍历所有后继节点
                for (int i = 0; i < adj[curCharIndex].size(); i++) {
                    char w = adj[curCharIndex].get(i);
                    inDegree[w - 'a']--;
                    if (inDegree[w - 'a'] == 0) {
                        queue.addLast(w);
                    }
                }
            }
        }

        StringBuilder ansSb = new StringBuilder();
        for (Character c: charList) {
            ansSb.append(c);
        }

        String ansStr = ansSb.toString();
        if (ansStr.length() < charSet.size()) {
            return "";
        }

        return ansStr;
    }

    public static void main(String[] args) {
        System.out.println(new Problem269().alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        }));

        System.out.println(new Problem269().alienOrder(new String[]{
                "z",
                "x"
        }));

        System.out.println(new Problem269().alienOrder(new String[]{
                "z",
                "x",
                "z"
        }));

        System.out.println(new Problem269().alienOrder(new String[]{
                "za",
                "zb",
                "ca",
                "cb"
        }));
    }

}
