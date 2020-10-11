package dianfeng_contest.S108;

import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/1
 */
public class B {

    private int[] getPos(int index) {
        return new int[]{index / 5, index % 5};
    }

    /**
     * playfair加密算法
     * @param key string字符串 密钥
     * @param str string字符串 明文
     * @return string字符串
     */
    public String Encode (String key, String str) {
        // write code here
        char[][] grid = new char[5][5];

        char[] keyArr = key.toCharArray();
        boolean[] visited = new boolean[26];
        int index = 0;
        for (char c : keyArr) {
            if (c == 'j') {
                c = 'i';
            }
            if (visited[c - 'a']) {
                continue;
            }

            visited[c - 'a'] = true;
            int[] pos = getPos(index);
            grid[pos[0]][pos[1]] = c;
            index++;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'j') {
                continue;
            }

            if (visited[c - 'a']) {
                continue;
            }

            int[] pos = getPos(index);
            grid[pos[0]][pos[1]] = c;
            index++;
        }

        int[] indexArr = new int[26];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                indexArr[grid[i][j] - 'a'] = i * 5 + j;
            }
        }

        char[] arr = str.toCharArray();
        int len = arr.length;

        StringBuilder ansSb = new StringBuilder();

        for (int i = 0; i < len; i += 2) {
            if (arr[i] == 'j') {
                arr[i] = 'i';
            }

            if (i == len - 1) {
                ansSb.append(arr[i]);
                continue;
            }

            if (arr[i + 1] == 'j') {
                arr[i + 1] = 'i';
            }

            if (arr[i] == arr[i + 1]) {
                ansSb.append(arr[i]);
                ansSb.append(arr[i + 1]);
                continue;
            }

            int index1 = indexArr[arr[i] - 'a'];
            int index2 = indexArr[arr[i + 1] - 'a'];

            int[] pos1 = getPos(index1);
            int[] pos2 = getPos(index2);

            if (pos1[0] == pos2[0]) {
                // 同一行
                ansSb.append(grid[pos1[0]][(pos1[1] + 1) % 5]);
                ansSb.append(grid[pos1[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                // 同一列
                ansSb.append(grid[(pos1[0] + 1) % 5][pos1[1]]);
                ansSb.append(grid[(pos2[0] + 1) % 5][pos1[1]]);
            } else {
                // 不同行不同列
                ansSb.append(grid[pos1[0]][pos2[1]]);
                ansSb.append(grid[pos2[0]][pos1[1]]);
            }
        }

        return ansSb.toString();
    }

}
