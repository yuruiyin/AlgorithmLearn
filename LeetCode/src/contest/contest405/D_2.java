package contest.contest405;


import utils.KMPUtil;

import java.util.*;

public class D_2 {

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9 + 7);
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
                hash[i] = (hash[i - 1] * P + arr[i]) % MOD;
                power[i] = (power[i - 1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r - l + 1] * hash[l - 1]) % MOD + MOD) % MOD;
        }

    }

    static class KMPUtil {

        public static void main(String[] args) {
            String source = "abchhabchabchabchcaaaabceabddh";
            String target = "abceab";
            System.out.println(kmpSearch(source, target));
        }

        public static int kmpSearch(char[] target, char[] pattern) {
            // 转为字符型数组
            // 获取next数组
            int[] next = next(pattern);
            int i = 0;// 主串下标
            int j = 0;// 模式串下标
            while (i < target.length && j < pattern.length) {
                if (j == -1 || target[i] == pattern[j]) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == pattern.length) {
                return i - pattern.length;
            }
            return -1;
        }

        public static int kmpSearch(String target, String pattern) {
            // 转为字符型数组
            char[] t = target.toCharArray();
            char[] p = pattern.toCharArray();
            return kmpSearch(t, p);
        }

        //next数组优化版
        public static int[] next(String pattern) {
            char[] t = pattern.toCharArray();
            return next(t);
        }

        public static int[] next(char[] t) {
            int[] next = new int[t.length];
            next[0] = -1;
            int k = -1;
            int j = 0;
            while (j < next.length - 1) {
                if (k == -1 || t[j] == t[k]) {
                    k++;
                    j++;
                    // ===============
                    // 较优化前的next数组求法，改变在以下四行代码。
                    if (t[j] != t[k]) {
                        next[j] = k;// 优化前只有这一行。
                    } else {
                        // 优化后因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归。
                        next[j] = next[k];
                    }
                    // ===============
                } else {
                    k = next[k];
                }
            }
            return next;
        }

    }

    private int[] dp;

    private char[] targetCharArr;

    private String target;

    private int len;

    private Map<Long, Integer> word2costMap;

    private StrHash strHash;

    private int[] wordLen2IdxMap;
    private int[] idx2WordLenMap;
    // 索引代表len的离散化后的值
    private List<Set<Long>> len2WordSetMap;

//    private List<Integer>[] idx2WordLenListArr;
    private int[][] idx2WordLenListArr;

    private int rec(int idx) {
        if (idx >= len) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ansMin = Integer.MAX_VALUE;
        for (int wordLen : idx2WordLenListArr[idx]) {
            if (wordLen == 0) {
                break;
            }
            long hash = strHash.getSubStrHash(idx, idx + wordLen - 1);
            int cost = word2costMap.get(hash);
            int tmpRes = rec(idx + wordLen);
            if (tmpRes != Integer.MAX_VALUE) {
                ansMin = Math.min(ansMin, tmpRes + cost);
            }
        }

        return dp[idx] = ansMin;
    }

    private void insertToMap(int targetStartIdx, Map<Long, Integer> word2costMap, String word, int cost, List<Set<Long>> len2WordListMap) {
        int curWordLen = word.length();
        int newCurWordLen = wordLen2IdxMap[curWordLen];
        long hash = strHash.getSubStrHash(targetStartIdx, targetStartIdx + curWordLen - 1);
        word2costMap.put(hash, cost);
        if (newCurWordLen == -1) {
            len2WordListMap.add(new HashSet<>());
            int idx = len2WordListMap.size() - 1;
            wordLen2IdxMap[curWordLen] = idx;
            idx2WordLenMap[idx] = curWordLen;
        }
        len2WordListMap.get(wordLen2IdxMap[curWordLen]).add(hash);
    }

    class Data {
        String word;
        int cost;
        Data(String word, int cost) {
            this.word = word;
            this.cost = cost;
        }
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        // <target的某个idx, 从target的某个idx中开始可从words中找到的idxList>
        word2costMap = new HashMap<>();
        len2WordSetMap = new ArrayList<>();
        targetCharArr = target.toCharArray();
        strHash = new StrHash(targetCharArr);

        Set<Integer> wordLenSet = new HashSet<>();
        for (String word : words) {
            wordLenSet.add(word.length());
        }

        wordLen2IdxMap = new int[50001];
        idx2WordLenMap = new int[wordLenSet.size()];
        Arrays.fill(wordLen2IdxMap, -1);

        int wordLen = words.length;
        Data[] datas = new Data[wordLen];
        for (int i = 0; i < wordLen; i++) {
            datas[i] = new Data(words[i], costs[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.word.length() - o2.word.length();
            }
        });

        for (int i = 0; i < wordLen; i++) {
            String word = datas[i].word;
            int cost = datas[i].cost;
            int idx = KMPUtil.kmpSearch(target, word);
            if (idx != -1) {
                long hash = strHash.getSubStrHash(idx, idx + word.length() - 1);
                if (word2costMap.containsKey(hash)) {
                    int oldCost = word2costMap.get(hash);
                    if (cost < oldCost) {
                        insertToMap(idx, word2costMap, word, cost, len2WordSetMap);
                    }
                } else {
                    insertToMap(idx, word2costMap, word, cost, len2WordSetMap);
                }
            }
        }

        System.out.println("hello world" + len2WordSetMap.size());
        Set<Long>[] len2WordSetArr = new HashSet[len2WordSetMap.size()];
        for (int i = 0; i < len2WordSetMap.size(); i++) {
            len2WordSetArr[i] = len2WordSetMap.get(i);
        }

        this.target = target;
        this.len = targetCharArr.length;
        dp = new int[len];
        Arrays.fill(dp, -1);
        int targetLen = target.length();

        int size = len2WordSetArr.length;
        idx2WordLenListArr = new int[len][size];
        for (int i = 0; i < len; i++) {
            int[] wordLenArr = new int[size];
            int idx = 0;
//            List<Integer> wordLenList = new ArrayList<>();
            for (int wordIdx = 0; wordIdx < size; wordIdx++) {
                Set<Long> wordHashSet = len2WordSetArr[wordIdx];
                int tmpWordLen = idx2WordLenMap[wordIdx];
                if (tmpWordLen + i > targetLen) {
                    break;
                }
                long hash = strHash.getSubStrHash(i, i + tmpWordLen - 1);
                if (wordHashSet.contains(hash)) {
                    wordLenArr[idx++] = tmpWordLen;
                }
            }
            idx2WordLenListArr[i] = wordLenArr;
        }

        System.out.println("hello world");

        int res = rec(0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void solve() {
        String target = "a".repeat(50000);
        String[] words = new String[]{"a", "a".repeat(49999)};
        int[] costs = new int[]{1, 1};
        System.out.println(new D_2().minimumCost(target, words, costs));
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
    }

}
