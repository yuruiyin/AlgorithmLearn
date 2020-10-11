package pre01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * D
 *
 * @author: yry
 * @date: 2020/8/29
 */
public class D {

    private char[] arr;
    private int[][] memo;

    private int rec(int l, int r) {
        if (l > r) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        if (arr[l] == arr[r]) {
            memo[l][r] = rec(l + 1, r - 1) + 1;
            if (memo[l][r] >= (r - l + 2) / 2) {
                memo[l][r] = r - l + 1;
            }
        } else {
            memo[l][r] = 0;
        }

        return memo[l][r];
    }

    /**
     * @param s: a string.
     * @return: return the values of all the intervals.
     */
    public long suffixQuery(String s) {
        // write your code here
        char[] arr = s.toCharArray();
        this.arr = arr;
        int len = arr.length;
        List<Integer>[] indexListArr = new ArrayList[26];

        for (int i = 0; i < len; i++) {
            if (indexListArr[arr[i] - 'a'] == null) {
                indexListArr[arr[i] - 'a'] = new ArrayList<>();
            }
            indexListArr[arr[i] - 'a'].add(i);
        }

        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> indexList = indexListArr[i];
            if (indexList == null) {
                continue;
            }
            int size = indexList.size();
            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int idxL = indexList.get(j);
                    int idxR = indexList.get(k);
                    ans += rec(idxL, idxR);
                }
            }
        }

        return ans + len;
    }
    
    public static void main(String[] args) {
        System.out.println(new D().suffixQuery("bacbdab"));
        System.out.println(new D().suffixQuery("bbb"));
        System.out.println(new D().suffixQuery("aba"));
        System.out.println(new D().suffixQuery("abba"));
        System.out.println(new D().suffixQuery("a"));
        System.out.println(new D().suffixQuery("aa"));
        System.out.println(new D().suffixQuery("abc"));
    }

}
