package problem201_300;

public class Problem211 {

    class WordDictionary {

        class TrieNode {
            private static final int N = 26;
            public TrieNode[] children;
            boolean mEnd;

            public TrieNode() {
                children = new TrieNode[26];
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
                mEnd = true;
            }

            public boolean isEnd() {
                return mEnd;
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                if (!node.hasChild(c)) {
                    node.put(c);
                }

                node = node.get(c);
            }

            node.setEnd();
        }

        private boolean backTrack(TrieNode node, char[] word, int from) {
            if (from == word.length) {
                return node.isEnd();
            }

            char c = word[from];

            if (c != '.') {
                // 字母
                if (!node.hasChild(c)) {
                    return false;
                }

                return backTrack(node.get(c), word, from + 1);
            } else {
                // . 代表任一字母
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] == null) {
                        continue;
                    }

                    boolean isFound = backTrack(node.children[i], word, from + 1);
                    if (isFound) {
                        return true;
                    }
                }

                return false;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return backTrack(root, word.toCharArray(), 0);
        }
    }

}
