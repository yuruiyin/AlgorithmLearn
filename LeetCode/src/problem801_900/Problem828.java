package problem801_900;

import java.util.Arrays;

public class Problem828 {

    public int uniqueLetterString(String s) {
        int[][] indexArr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(indexArr[i], -1);
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 1;
        indexArr[arr[0] - 'A'][0] = 0;
        int pre = 1;
        for (int i = 1; i < len; i++) {
            int[] preIdxs = indexArr[arr[i] - 'A'];
            if (preIdxs[0] == -1) {
                // 前面没有当前字符
                pre += i + 1;
            } else {
                // 前面找到当前字符(可能是1个，可能是多个)
//                pre += i - preIdxs[0] - (preIdxs[0] - preIdxs[1]);
                pre += i - (preIdxs[0] << 1) + preIdxs[1];
            }
            ans += pre;
            indexArr[arr[i] - 'A'][1] = indexArr[arr[i] - 'A'][0];
            indexArr[arr[i] - 'A'][0] = i;
        }
        return ans;
    }

}
