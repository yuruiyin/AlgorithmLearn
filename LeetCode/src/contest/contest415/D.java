package contest.contest415;

import java.util.Arrays;

public class D {

    static class Trie {
        private Trie[] children;
        private boolean mIsEnd;
        private int height;

        private int wordIdx;

        private int wordLen;

        public Trie() {
            children = new Trie[26];
        }

        public void addChild(char c, int wordIdx, int wordLen) {
            Trie trie = new Trie();
            trie.wordIdx = wordIdx;
            trie.wordLen = wordLen;
            children[c - 'a'] = trie;
        }

        private int getWordIdx() {
            return wordIdx;
        }

        public void setWordIdx(int wordIdx) {
            this.wordIdx = wordIdx;
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public Trie getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd() {
            this.mIsEnd = true;
        }

        public boolean isEnd() {
            return mIsEnd;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWordLen() {
            return wordLen;
        }

        public void setWordLen(int wordLen) {
            this.wordLen = wordLen;
        }
    }

    private Trie root;
    private int[] dp;
    private char[] arr;
    private int len;

    private void addWord(String word, int wordIdx) {
        Trie cur = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!cur.hasChild(c)) {
                cur.addChild(c, wordIdx, word.length());
            } else {
                Trie child = cur.getChild(c);
                if (word.length() < child.getWordLen()) {
                    child.setWordLen(word.length());
                    child.setWordIdx(wordIdx);
                }
            }
            cur = cur.getChild(c);
        }
        cur.setEnd();
    }

    private void createWordsTrie(String[] words) {
        root = new Trie();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            addWord(words[i], i);
        }
    }

    private int rec(int curIdx) {
        if (curIdx == len) {
            return 0;
        }

        if (dp[curIdx] != -2) {
            return dp[curIdx];
        }

        int minCount = len + 1;
        // trie树上db
        Trie cur = root;
        for (int i = curIdx; i < len; i++) {
            char c = arr[i];
            if (!cur.hasChild(c)) {
                break;
            }
            cur = cur.getChild(c);
            int tmpRes = rec(i + 1);
            if (tmpRes == -1) {
                continue;
            }
            minCount = Math.min(minCount, 1 + tmpRes);
        }

        return dp[curIdx] = minCount == len + 1 ? -1 : minCount;
    }

    public int minValidStrings(String[] words, String target) {
        createWordsTrie(words);
        this.arr = target.toCharArray();
        this.len = arr.length;
        dp = new int[len];
        Arrays.fill(dp, -2);
        return rec(0);
    }

}
