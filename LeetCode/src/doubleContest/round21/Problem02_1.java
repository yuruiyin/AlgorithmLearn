package doubleContest.round21;

import java.util.Arrays;

public class Problem02_1 {

    public int findTheLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int[] map = new int[26];
        Arrays.fill(map, -1);
        map['a' - 'a'] = 0;
        map['e' - 'a'] = 1;
        map['i' - 'a'] = 2;
        map['o' - 'a'] = 3;
        map['u' - 'a'] = 4;
        int pre = 0;
        int ansMax = 0;

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (map[c - 'a'] != -1) {
                pre ^= (1 << map[c - 'a']);
            }

            if (pos[pre] != -1) {
                ansMax = Math.max(ansMax, i - pos[pre] + 1);
            } else {
                pos[pre] = i + 1;
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem02_1().findTheLongestSubstring("bcbcbc"));
    }

}
