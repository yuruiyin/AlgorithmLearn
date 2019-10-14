package problem301_400;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem354 {

    class Data {
        int w;
        int h;
        Data(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    class CustomCmp implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.w != o2.w ? o1.w - o2.w : o1.h - o2.h;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }

        List<Data> datas = new ArrayList<>();

        for (int[] envelope : envelopes) {
            datas.add(new Data(envelope[0], envelope[1]));
        }

        datas.sort(new CustomCmp());

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            Data curData = datas.get(i);
            int max = 1;
            for (int j = 0; j < i; j++) {
                Data tmpData = datas.get(j);
                if (curData.w > tmpData.w && curData.h > tmpData.h && dp[j] + 1 > max) {
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }

}
