package contest.contest291;

import java.util.Arrays;

public class D {

    public long appealSum(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        long ans = 1;
        long pre = 1;
        int[] preIdxArr = new int[26];
        Arrays.fill(preIdxArr, -1);
        preIdxArr[arr[0] - 'a'] = 0;
        for (int i = 1; i < len; i++) {
            int offset = preIdxArr[arr[i] - 'a'] == -1 ? 0 : preIdxArr[arr[i] - 'a'] + 1;
            ans += pre + i + 1 - offset;
            pre += i + 1 - offset;
            preIdxArr[arr[i] - 'a'] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().appealSum("abbca"));
        System.out.println("hello world");
    }

}
