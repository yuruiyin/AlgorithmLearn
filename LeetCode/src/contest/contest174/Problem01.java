package contest.contest174;

import java.util.Arrays;
import java.util.Comparator;

public class Problem01 {

    class Data {
        int oneCount;
        int index;
        Data(int oneCount, int index) {
            this.oneCount = oneCount;
            this.index = index;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        Data[] datas = new Data[m];

        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += mat[i][j];
            }

            datas[i] = new Data(count, i);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.oneCount == o2.oneCount) {
                    return o1.index - o2.index;
                }

                return o1.oneCount - o2.oneCount;
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = datas[i].index;
        }

        return ans;
    }

}
