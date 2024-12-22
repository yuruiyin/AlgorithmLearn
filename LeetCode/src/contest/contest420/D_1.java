package contest.contest420;

import java.util.*;

/**
 * 使用 字符串hash + 链表 优化时间复杂度
 */
public class D_1 {

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

    }

    static class Node {
        Node next;

        int idx;

        Node(int idx) {
            this.idx = idx;
        }
    }

    static class Range {
        Node start;
        Node end;

        int len;

        Range(Node start, Node end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    private TreeSet<Integer>[] adj;

    private int[] childCount;

    private Range rec(int idx) {
        TreeSet<Integer> nextSet = adj[idx];
        Range curRange = null;
        for (int next : nextSet) {
            Range tmpRange = rec(next);
            if (curRange != null) {
                curRange.end.next = tmpRange.start;
                curRange.end = tmpRange.end;
                curRange.len += tmpRange.len;
            } else {
                curRange = tmpRange;
            }
        }

        Node curNode = new Node(idx);
        if (curRange == null) {
            curRange = new Range(curNode, curNode, 1);
        } else {
            curRange.end.next = curNode;
            curRange.end  = curNode;
            curRange.len++;
        }
        childCount[idx] = curRange.len;
        return curRange;
    }

    private char[][] convertToArr(Range range, char[] arr) {
        int len = range.len;
        char[][] ansArr = new char[2][len];
        Node curNode = range.start;
        int idx = 0;
        while (curNode != null) {
            ansArr[0][idx] = arr[curNode.idx];
            ansArr[1][len - idx - 1] = ansArr[0][idx];
            idx++;
            curNode = curNode.next;
        }
        return ansArr;
    }

    public boolean[] findAnswer(int[] parent, String s) {
        char[] arr = s.toCharArray();
        int n = parent.length;
        this.adj = new TreeSet[n];
        Arrays.setAll(adj, value -> new TreeSet<>());
        for (int i = 1; i < n; i++) {
            int p = parent[i];
            adj[p].add(i);
        }

        childCount = new int[n];
        Range range = rec(0);
        char[][] strArr = convertToArr(range, arr);
        StrHash strHash = new StrHash(strArr[0]);
        StrHash reverseStrHash = new StrHash(strArr[1]);

        int[] idxMap = new int[n];
        int idx = 0;
        Node curNode = range.start;
        while (curNode != null) {
            idxMap[curNode.idx] = idx;
            curNode = curNode.next;
            idx++;
        }

        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; i++) {
            int rightIdx = idxMap[i];
            int count = childCount[i];
            int leftIdx = rightIdx - count + 1;
            if (count == 1) {
                ans[i] = true;
                continue;
            }

            int eachCount = count / 2;
            long leftHash = strHash.getSubStrHash(leftIdx, leftIdx + eachCount - 1);
            long rightHash = reverseStrHash.getSubStrHash(n - rightIdx - 1, n - rightIdx - 1 + eachCount - 1);
            if (leftHash == rightHash) {
                ans[i] = true;
            }
        }

        return ans;
    }

}
