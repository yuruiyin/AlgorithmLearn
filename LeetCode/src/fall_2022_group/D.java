package fall_2022_group;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D {

    private Map<String, Integer> memoMap;

    private int len;

    private char[][] grid;
    private int[] flag;

    private int[] map;

    private boolean isEmpty(int[] countArr) {
        for (int i = 0; i < 7; i++) {
            if (countArr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private String generateKey(int[] words) {
        StringBuilder sb = new StringBuilder();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            sb.append(words[i]).append(',');
        }
        return sb.toString();
    }

    private int rec(int[] words, int[] countArr) {
        if (isEmpty(countArr)) {
            // 全取完了
            return 0;
        }

        String key = generateKey(words);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 字母取的顺序会影响结果
        // 如果一个单词中有多个相同字母，则应该取越靠两边的
        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int word = words[i];
            if (word == 0) {
                // 说明当前单词的字母已被全部取走
                continue;
            }
            int bitOneCount = Integer.bitCount(word);
            int oneCount = 0;
            for (int j = 0; j < 8; j++) {
                if (j >= grid[i].length) {
                    break;
                }
                if ((word & (1 << j)) == 0) {
                    continue;
                }
                oneCount++;
                char curC = grid[i][j];
                int charIdx = map[curC - 'a'];
                if (charIdx == -1) {
                    continue;
                }
                int count = countArr[charIdx];
                if (count > 0) {
                    // 删除
                    words[i] ^= (1 << j);
                    countArr[charIdx]--;
                    int tmpRes = rec(words, countArr);
                    words[i] ^= (1 << j);
                    countArr[charIdx]++;
                    if (tmpRes != -1) {
                        ansMin = Math.min(ansMin, tmpRes + (oneCount - 1) * (bitOneCount - oneCount));
                    } else {
                        memoMap.put(key, -1);
                        return -1;
                    }
                }
            }
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
        return rec(flag, countArr);
    }

    public static void main(String[] args) {
        System.out.println(new D().Leetcode(new String[]{"hold","engineer","cost","level"}));
    }

}
