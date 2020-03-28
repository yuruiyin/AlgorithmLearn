package lcci;

import java.util.Arrays;

/**
 * Lcci17113 使用字典树优化
 *
 * @author: yry
 * @date: 2020/3/28
 */
public class Lcci1713_1 {

    class TrieNode {
        private TrieNode[] children;
        private boolean mIsEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public void addChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        private TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void setEnd(boolean isEnd) {
            mIsEnd = isEnd;
        }

        public boolean isEnd() {
            return mIsEnd;
        }
    }

    private TrieNode root;
    private int len;
    private int[] memo;
    private char[] arr;

    private int dp(int start) {
        if (start == len) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int ansMin = 1 + dp(start + 1);
        for (int end = start; end < len; end++) {
            if (!isPrefix(start, end)) {
                break;
            }

            if (contains(start, end)) {
                ansMin = Math.min(ansMin, dp(end + 1));
            }
        }

        memo[start] = ansMin;
        return ansMin;
    }

    private boolean contains(int left, int right) {
        TrieNode cur = root;
        for (int i = left; i <= right; i++) {
            char c = arr[i];
            if (!cur.hasChild(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return cur.isEnd();
    }

    private boolean isPrefix(int left, int right) {
        TrieNode cur = root;
        for (int i = left; i <= right; i++) {
            char c = arr[i];
            if (!cur.hasChild(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return true;
    }

    private void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.hasChild(c)) {
                cur.addChild(c);
            }

            cur = cur.getChild(c);
        }

        cur.setEnd(true);
    }

    private void createTrie(String[] dictionary) {
        root = new TrieNode();
        for (String word : dictionary) {
            addWord(word);
        }
    }

    public int respace(String[] dictionary, String sentence) {
        createTrie(dictionary);
        arr = sentence.toCharArray();
        len = sentence.length();
        memo =  new int[len];
        Arrays.fill(memo, -1);
        return dp(0);
    }

}
