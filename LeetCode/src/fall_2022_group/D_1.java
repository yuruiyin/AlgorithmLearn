package fall_2022_group;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D_1 {

    private Map<Long, Integer> memoMap;

    private int len;

    private char[][] grid;
    private int[] flag;

    private int[] map;

    private final long[] offsetArr = new long[]{5, 13, 16, 18, 20, 21, 22, 23, 24};

    private boolean isEmpty(int[] countArr) {
        for (int i = 0; i < 7; i++) {
            if (countArr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private long getKey(int wordIdx, int visited, int[] countArr, int curWord) {
        // curIdx: [0, 23]
        long key = wordIdx;
        key += ((long)visited << offsetArr[0]);
        for (int i = 0; i < countArr.length; i++) {
            key += ((long)countArr[i] << offsetArr[i + 1]);
        }
        key += ((long)curWord << offsetArr[offsetArr.length - 1]);
        return key;
    }

    private int[] getNextIdx(int wordIdx, int charIdx) {
        int wordLen = grid[wordIdx].length;
        if (charIdx == wordLen - 1) {
            return new int[]{wordIdx + 1, 0};
        }
        return new int[]{wordIdx, charIdx + 1};
    }

    private int getCostIfChoose(int word, int charIdx) {
        int bitOneCount = Integer.bitCount(word);
        int highOneCount = Integer.bitCount(word - (word & ((1 << (charIdx + 1)) - 1)));
        return highOneCount * (bitOneCount - highOneCount - 1);
    }

    private int rec(int[] words, int wordIdx, int visited, int[] countArr) {
        if (isEmpty(countArr)) {
            return 0;
        }

        if (wordIdx == len) {
            return -1;
        }

        int curWord = words[wordIdx];
        long key = getKey(wordIdx, visited, countArr, curWord);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (visited == (1 << grid[wordIdx].length) - 1) {
            return rec(words, wordIdx + 1, 0, countArr);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < grid[wordIdx].length; i++) {
            if ((visited & (1 << i)) != 0) {
                // 之前已经考虑过了
                continue;
            }

            visited ^= (1 << i);
            char curChar = grid[wordIdx][i];
            int mapCharIdx = map[curChar - 'a'];
            int count = mapCharIdx == -1 ? 0 : countArr[mapCharIdx];
            if (mapCharIdx == -1 || count == 0) {
                // 不是需要取的字母
                int tmpRes = rec(words, wordIdx, visited, countArr);
                if (tmpRes != -1) {
                    ansMin = Math.min(ansMin, tmpRes);
                }
                visited ^= (1 << i);
                continue;
            }

            // 不选
            int nonChooseRes = rec(words, wordIdx, visited, countArr);
            int cost = getCostIfChoose(curWord, i);
//            System.out.println(cost);
            words[wordIdx] ^= (1 << i);
            countArr[mapCharIdx]--;
            int chooseRes = rec(words, wordIdx, visited, countArr);
            words[wordIdx] ^= (1 << i);
            countArr[mapCharIdx]++;
            if (nonChooseRes != -1) {
                ansMin = Math.min(ansMin, nonChooseRes);
            }
            if (chooseRes != -1) {
                ansMin = Math.min(ansMin, chooseRes + cost);
            }
            visited ^= (1 << i);
        }

        if (ansMin == Integer.MAX_VALUE) {
            memoMap.put(key, -1);
            return -1;
        }
        memoMap.put(key, ansMin);
        return ansMin;
    }

    private void generateGrid(String[] words) {
        grid = new char[len][];
        flag = new int[len];
        for (int i = 0; i < len; i++) {
            grid[i] = words[i].toCharArray();
            flag[i] = (1 << grid[i].length) - 1;
        }
    }

    public int Leetcode(String[] words) {
        map = new int[26];
        Arrays.fill(map, -1);
        map['e' - 'a'] = 0;
        map['l' - 'a'] = 1;
        map['o' - 'a'] = 2;
        map['h' - 'a'] = 3;
        map['c' - 'a'] = 4;
        map['d' - 'a'] = 5;
        map['t' - 'a'] = 6;
        int[] countArr = new int[7];
        countArr[0] = 4;
        countArr[1] = 3;
        countArr[2] = 2;
        countArr[3] = 1;
        countArr[4] = 1;
        countArr[5] = 1;
        countArr[6] = 1;
        memoMap = new HashMap<>();
        this.len = words.length;
        generateGrid(words);
        int ans = rec(flag, 0, 0, countArr);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D_1().Leetcode(new String[]{"hold","engineer","cost","level"}));
//        System.out.println(new D_1().Leetcode(new String[]{"hold","engineer"}));
    }

}
