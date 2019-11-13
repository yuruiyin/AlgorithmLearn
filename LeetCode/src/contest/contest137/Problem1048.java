package contest.contest137;

import java.util.*;

public class Problem1048 {

    private boolean isOneCharDiff(String lessStr, String moreStr) {
        char[] lessArr = lessStr.toCharArray();
        char[] moreArr = moreStr.toCharArray();

        Arrays.sort(lessArr);
        Arrays.sort(moreArr);

        int i;
        int j;
        for (i = 0, j = 0; i < lessArr.length && j < moreArr.length; ) {
            if (lessArr[i] == moreArr[j]) {
                i++;
                j++;
                continue;
            }

            j++;
        }

        return i + 1 == j || i == j;
    }

    private int[] memo;

    private int backTrack(String[] words, int from, Map<String, List<Integer>> map) {
        if (memo[from] > 0) {
            return memo[from];
        }

        String curWord = words[from];

        if (!map.containsKey(curWord)) {
            memo[from] = 1;
            return 1;
        }

        int max = Integer.MIN_VALUE;
        for (Integer nextWordIndex: map.get(curWord)) {
            int res = backTrack(words, nextWordIndex, map);
            if (res > max) {
                max = res;
            }
        }

        memo[from] = 1 + max;
        return 1 + max;
    }

    public int longestStrChain(String[] words) {
        int len = words.length;
        if (len == 1) {
            return 1;
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] lenIndexArr = new int[18];
        Arrays.fill(lenIndexArr, -1);
        lenIndexArr[words[0].length()] = 0;

        for (int i = 1; i < len; i++) {
            if (words[i].length() != words[i-1].length()) {
                lenIndexArr[words[i].length()] = i;
            }
        }

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String word = words[i];
            int curLen = word.length();
            if (lenIndexArr[curLen + 1] == -1) {
                continue;
            }

            for (int j = lenIndexArr[curLen + 1]; j < len && words[j].length() == curLen + 1; j++) {
                String tmpWord = words[j];
                if (isOneCharDiff(word, tmpWord)) {
                    if (map.containsKey(word)) {
                        map.get(word).add(j);
                    } else {
                        List<Integer> wordList = new ArrayList<>();
                        wordList.add(j);
                        map.put(word, wordList);
                    }
                }
            }
        }

        int ansMax = Integer.MIN_VALUE;
        memo = new int[len];
        for (int i = 0; i < len; i++) {
            if (memo[i] > 0) {
                continue;
            }
            int res = backTrack(words, i, map);
            if (res > ansMax) {
                ansMax = res;
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq"
                ,"gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"
        }));
    }
    
}
