package contest.contest415;

import java.util.*;

public class C {

    private Set<String> set;

    private char[] arr;
    private int len;

    private int[] dp;

    private List<Integer>[] nextListArr;

    private int rec(int curIdx) {
        if (curIdx == len) {
            return 0;
        }

        if (dp[curIdx] != -2) {
            return dp[curIdx];
        }

        int minCount = len + 1;
        StringBuilder sb = new StringBuilder();
        List<Integer> nextList = nextListArr[curIdx];
        for (int i : nextList) {
            sb.append(arr[i]);
            if (!set.contains(sb.toString())) {
                continue;
            }
            int tmpRes = rec(i + 1);
            if (tmpRes == -1) {
                continue;
            }
            minCount = Math.min(minCount, 1 + tmpRes);
        }

        return dp[curIdx] = minCount == len + 1 ? -1 : minCount;
    }

    public int minValidStrings(String[] words, String target) {
        this.set = new HashSet<>();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(word.charAt(i));
                set.add(sb.toString());
            }
        }

        this.arr = target.toCharArray();
        this.len = arr.length;
        this.nextListArr = new ArrayList[len];
        Arrays.setAll(this.nextListArr, value -> new ArrayList<>());
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                sb.append(arr[j]);
                if (set.contains(sb.toString())) {
                    this.nextListArr[i].add(j);
                }
            }
        }

        System.out.println("hello");

        dp = new int[len];
        Arrays.fill(dp, -2);
        return rec(0);
    }

}
