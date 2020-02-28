package doubleContest.round20;

import java.util.Arrays;
import java.util.Comparator;

public class Problem01 {

    class Data {
        int oneCount;
        int val;
        Data(int oneCount, int val) {
            this.oneCount = oneCount;
            this.val = val;
        }
    }

    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(Integer.bitCount(arr[i]), arr[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.oneCount == o2.oneCount) {
                    return o1.val - o2.val;
                }
                return o1.oneCount - o2.oneCount;
            }
        });

        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = datas[i].val;
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
