package problem801_900;

import java.util.Arrays;
import java.util.Comparator;

// 本质是贪心
public class Problem870 {

    class Data {
        int val;
        int index;
        Data(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public int[] advantageCount(int[] arr1, int[] arr2) {
        int len = arr1.length;
        Data[] datas2 = new Data[len];
        for (int i = 0; i < len; i++) {
            datas2[i] = new Data(i, arr2[i]);
        }

        Arrays.sort(datas2, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.val - o1.val;
            }
        });

        Arrays.sort(arr1);

        int left = 0;
        int right = len - 1;
        int[] ansArr = new int[len];

        for (int i = 0; i < len; i++) {
            // 从大的数字，如果在数组1中能找到比他大的，那么改位置就用这个大的数字，否则用最小的数字，因为最小的数字作用最小。
            if (arr1[right] > datas2[i].val) {
                ansArr[datas2[i].index] = arr1[right];
                right--;
            } else {
                ansArr[datas2[i].index] = arr1[left];
                left++;
            }
        }

        return ansArr;
    }

}
