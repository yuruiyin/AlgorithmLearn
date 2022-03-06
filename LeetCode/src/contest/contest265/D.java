package contest.contest265;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/31
 */
public class D {

    private char[] arr1;
    private char[] arr2;
    private int len1;
    private int len2;
    private Boolean[][] memo;

    private boolean rec(int i1, int i2, int used1, int used2) {
        if (i1 == len1 && i2 < len2 || i1 < len1 && i2 == len2) {
            return false;
        }

        if (memo[i1][i2] != null) {
            return memo[i1][i2];
        }

        if (Character.isLowerCase(arr1[i1]) && Character.isLowerCase(arr2[i2])) {
            if (arr1[i1] != arr2[i2]) {
                return false;
            }

            return rec(i1 + 1, i2 + 1, 0, 0);
        }

        if (Character.isLowerCase(arr1[i1]) && !Character.isLowerCase(arr2[i2])) {
            // arr2[i2] 是数字
            int curNum = 0;
            for (int i = i2; i < len2 && !Character.isLowerCase(arr2[i]); i++) {
                curNum *= 10;
                curNum += (arr2[i] - '0');
                boolean isOk = true;
                
                for (int j = i1; j < len1; j++) {

                }
            }
        } else if (!Character.isLowerCase(arr1[i1]) && Character.isLowerCase(arr2[i2])) {
            // arr1[i1] 是数字
        } else {
            // 二者都是数字
        }

        return true;
    }

    public boolean possiblyEquals(String s1, String s2) {
        arr1 = s1.toCharArray();
        arr2 = s2.toCharArray();
        this.len1 = arr1.length;
        this.len2 = arr2.length;
        memo = new Boolean[len1 + 1][len2 + 1];
        return rec(0, 0, 0, 0);
    }

}
