package problem401_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem474
 *
 * @author: yry
 * @date: 2020/4/3
 */
public class Problem474 {

    class Data {
        int zeroCount;
        int oneCount;
        Data(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }
    }

    private int len;
    private Data[] datas;
    private Integer[][][] memo;

    private int getZeroCount(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                ans++;
            }
        }
        return ans;
    }

    private int dp(int idx, int zeroCount, int oneCount) {
        if (idx == len) {
            return 0;
        }

        if (zeroCount < datas[idx].zeroCount) {
            // 因为datas是按照zeroCount从小到大排序的
            return 0;
        }

        if (memo[idx][zeroCount][oneCount] != null) {
            return memo[idx][zeroCount][oneCount];
        }

        Data data = datas[idx];
        if (data.zeroCount <= zeroCount && data.oneCount <= oneCount) {
            int choose = dp(idx + 1, zeroCount - data.zeroCount, oneCount - data.oneCount) + 1;
            int nonChoose = dp(idx + 1, zeroCount, oneCount);
            memo[idx][zeroCount][oneCount] = Math.max(choose, nonChoose);
        } else {
            memo[idx][zeroCount][oneCount] = dp(idx + 1, zeroCount, oneCount);
        }
        return memo[idx][zeroCount][oneCount];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        this.len = strs.length;
        datas = new Data[len];
        for (int i = 0; i < len; i++) {
            int zeroCount = getZeroCount(strs[i]);
            datas[i] = new Data(zeroCount, strs[i].length() - zeroCount);
        }

        Arrays.sort(datas, Comparator.comparingInt(o -> o.zeroCount));
        memo = new Integer[len + 1][m + 1][n + 1];
        return dp(0, m, n);
    }

}
