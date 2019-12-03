package problem201_300;

public class Problem208 {

    class Trie {

        class TrieNode {
            private static final int N = 26;
            private TrieNode[] children;
            private boolean isEnd; // 是否是某个单词的最后一个字符

            public TrieNode() {
                children = new TrieNode[N];
            }

            public boolean hasChild(char c) {
                return children[c - 'a'] != null;
            }

            public void put(char c) {
                children[c - 'a'] = new TrieNode();
            }

            public TrieNode get(char c) {
                return children[c - 'a'];
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }

        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            int len = word.length();
            TrieNode node = root;

            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (!node.hasChild(c)) {
                    node.put(c);
                }

                node = node.get(c);
            }

            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            int len = word.length();
            TrieNode node = root;

            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (!node.hasChild(c)) {
                    return false;
                }

                node = node.get(c);
            }

            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int len = prefix.length();
            TrieNode node = root;

            for (int i = 0; i < len; i++) {
                char c = prefix.charAt(i);
                if (!node.hasChild(c)) {
                    return false;
                }

                node = node.get(c);
            }

            return true;
        }
    }

}
