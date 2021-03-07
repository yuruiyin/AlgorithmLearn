package doubleContest.round47;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class C {

    public int beautySum(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] preCountArr = new int[len][26];

        preCountArr[0][arr[0] - 'a']++;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                if (j == arr[i] - 'a') {
                    preCountArr[i][j] = preCountArr[i - 1][j] + 1;
                } else {
                    preCountArr[i][j] = preCountArr[i - 1][j];
                }
            }
        }

        int ans = 0;

        for (int l = 0; l < len - 1; l++) {
            for (int r = l + 1; r < len; r++) {
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int i = 0; i < 26; i++) {
                    int count = l == 0 ? preCountArr[r][i] : preCountArr[r][i] - preCountArr[l - 1][i];
                    if (count == 0) {
                        continue;
                    }
                    min = Math.min(min, count);
                    max = Math.max(max, count);
                }

                ans += max - min;
            }
        }

        return ans;
    }

}
