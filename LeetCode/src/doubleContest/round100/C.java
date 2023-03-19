package doubleContest.round100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class C {

    class Data {
        int num;
        int idx;
        Data(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public long findScore(int[] nums) {
        int len = nums.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(i, nums[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num == o2.num ? o1.idx - o2.idx : o1.num - o2.num;
            }
        });

        long ans = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            int idx = datas[i].idx;
            if (visited[idx]) {
                continue;
            }
            visited[idx] = true;
            ans += datas[i].num;
            if (idx > 0) {
                visited[idx - 1] = true;
            }
            if (idx + 1 < len) {
                visited[idx + 1] = true;
            }
        }

        return ans;
    }

}
