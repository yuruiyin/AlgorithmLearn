package problem601_700;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem677
 *
 * @author: yry
 * @date: 2020/4/3
 */
public class Problem677 {

    static class MapSum {

        class Trie {
            private Trie[] children;
            private boolean mIsEnd;

            public Trie() {
                children = new Trie[26];
            }

            private void addChild(char c) {
                children[c - 'a'] = new Trie();
            }

            private Trie getChild(char c) {
                return children[c - 'a'];
            }

            private boolean hasChild(char c) {
                return children[c - 'a'] != null;
            }

            private void setEnd() {
                this.mIsEnd = true;
            }

            private boolean getIsEnd() {
                return mIsEnd;
            }
        }

        private void addWord(String word) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.hasChild(c)) {
                    cur.addChild(c);
                }

                cur = cur.getChild(c);
            }

            cur.setEnd();
        }

        private Trie root;
        private Map<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Trie();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
            addWord(key);
        }

        private int rec(Trie cur, StringBuilder sb) {
            if (cur == null) {
                return 0;
            }

            int ans = 0;
            if (cur.getIsEnd()) {
                ans += map.get(sb.toString());
            }

            for (int i = 0; i < 26; i++) {
                Trie child = cur.children[i];
                if (child == null) {
                    continue;
                }

                sb.append((char)(i + 'a'));
                ans += rec(child, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            return ans;
        }

        public int sum(String prefix) {
            Trie cur = root;
            for (char c : prefix.toCharArray()) {
                if (!cur.hasChild(c)) {
                    return 0;
                }

                cur = cur.getChild(c);
            }

            // 遍历所有的从当前节点开始的所有单词
            return rec(cur, new StringBuilder(prefix));
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
    }

}
