package contest.contest214;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class B {

    public int minDeletions(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] countArr = new int[26];
        for (char c : arr) {
            countArr[c - 'a']++;
        }

        Arrays.sort(countArr);
        boolean[] visited = new boolean[len + 1];
        if (countArr[0] != 0) {
            visited[countArr[0]] = true;
        }

        int ans = 0;
        for (int i = 1; i < 26; i++) {
            if (countArr[i] != 0) {
                visited[countArr[i]] = true;
            }
            if (countArr[i] != 0 && countArr[i] == countArr[i - 1]) {
                for (int j = countArr[i - 1]; j >= 0; j--) {
                    if (visited[j]) {
                        continue;
                    }
                    if (j != 0) {
                        visited[j] = true;
                    }
                    ans += countArr[i] - j;
                    break;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().minDeletions("aaabbbcc"));
    }

}
