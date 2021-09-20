package contest.contest244;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/6
 */
public class C {

    public int minFlips(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] suffixDp = new int[len][2];
        suffixDp[len - 1][0] = arr[len - 1] == '0' ? 0 : 1;
        suffixDp[len - 1][1] = arr[len - 1] == '1' ? 0 : 1;

        for (int i = len - 2; i >= 0; i--) {
            suffixDp[i][0] = suffixDp[i + 1][1] + (arr[i] == '0' ? 0 : 1);
            suffixDp[i][1] = suffixDp[i + 1][0] + (arr[i] == '1' ? 0 : 1);
        }

        int[][] prefixDp = new int[len][2];
        prefixDp[0][0] = arr[0] == '0' ? 0 : 1;
        prefixDp[0][1] = arr[0] == '1' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            prefixDp[i][0] = prefixDp[i - 1][1] + (arr[i] == '0' ? 0 : 1);
            prefixDp[i][1] = prefixDp[i - 1][0] + (arr[i] == '1' ? 0 : 1);
        }

        int ansMin = Math.min(suffixDp[0][0], suffixDp[0][1]);

        for (int i = 1; i < len; i++) {
            int suffixCount = len - i;
            int prefixCount = i;
            if (suffixCount % 2 == 1) {
                if (prefixCount % 2 == 0) {
                    ansMin = Math.min(ansMin, suffixDp[i][0] + prefixDp[i - 1][0]);
                    ansMin = Math.min(ansMin, suffixDp[i][1] + prefixDp[i - 1][1]);
                } else {
                    ansMin = Math.min(ansMin, suffixDp[i][0] + prefixDp[i - 1][1]);
                    ansMin = Math.min(ansMin, suffixDp[i][1] + prefixDp[i - 1][0]);
                }
            } else {
                if (prefixCount % 2 == 0) {
                    ansMin = Math.min(ansMin, suffixDp[i][0] + prefixDp[i - 1][1]);
                    ansMin = Math.min(ansMin, suffixDp[i][1] + prefixDp[i - 1][0]);
                } else {
                    ansMin = Math.min(ansMin, suffixDp[i][0] + prefixDp[i - 1][0]);
                    ansMin = Math.min(ansMin, suffixDp[i][1] + prefixDp[i - 1][1]);
                }
            }
        }

        return ansMin;

    }

}
