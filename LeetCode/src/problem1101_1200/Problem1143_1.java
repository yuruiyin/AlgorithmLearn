package problem1101_1200;

/**
 * 最长公共子序列(LCS)一维dp版本
 * 记录上一行和当前行的一维数组即可
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Problem1143_1 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] curRowDp = new int[len2];
        int[] preRowDp = new int[len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (arr1[i] == arr2[j]) {
                    curRowDp[j] = i == 0 || j == 0 ? 1 : preRowDp[j-1] + 1;
                } else {
                    curRowDp[j] = Math.max((j == 0 ? 0 : curRowDp[j-1]), preRowDp[j]);
                }
            }
//            preRowDp = curRowDp; // 不能直接这样，这样的话相当于curRowDp和preRowDp都指向了同一个对象数组
            int[] tmp = curRowDp;
            curRowDp = preRowDp;
            preRowDp = tmp;
        }

        return preRowDp[len2 - 1];
    }

}
