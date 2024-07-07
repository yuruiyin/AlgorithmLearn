package contest.contest405;


import java.util.Arrays;

public class D {

    class Trie {
        private Trie[] children;
        private int cost = -1;

        public Trie() {
            children = new Trie[26];
        }

        public void addChild(char c) {
            Trie trie = new Trie();
            children[c - 'a'] = trie;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public boolean hasChild(char c) {
            return children[c - 'a'] != null;
        }

        public Trie getChild(char c) {
            return children[c - 'a'];
        }

    }

    private int[] dp;

    private char[] targetCharArr;

    private int len;

    private Trie root;

    private int rec(int idx) {
        if (idx == len) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ansMin = Integer.MAX_VALUE;
        // root是空的节点
        Trie cur = root;
        for (int i = idx; i < len; i++) {
            char c = targetCharArr[i];
            Trie child = cur.getChild(c);
            if (child == null) {
                break;
            }

            int cost = child.cost;
            if (cost != -1) {
                int tmpRes = rec(i + 1);
                if (tmpRes != Integer.MAX_VALUE) {
                    ansMin = Math.min(ansMin, tmpRes + cost);
                }
            }
            cur = child;
        }

        return dp[idx] = ansMin;
    }

    private void addWord(String word, int cost) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.hasChild(c)) {
                cur.addChild(c);
            }
            cur = cur.getChild(c);
        }

        if (cur.cost == -1) {
            cur.cost = cost;
        } else {
            cur.cost = Math.min(cur.cost, cost);
        }
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        this.root = new Trie();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], costs[i]);
        }

        targetCharArr = target.toCharArray();
        this.len = targetCharArr.length;
        dp = new int[len];
        Arrays.fill(dp, -1);
        int res = rec(0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
