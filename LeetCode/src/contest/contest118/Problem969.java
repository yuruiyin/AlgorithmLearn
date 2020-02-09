package contest.contest118;

import java.util.ArrayList;
import java.util.List;

public class Problem969 {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public List<Integer> pancakeSort(int[] arr) {
        // 每次把最大的沉底。先弄到第一个位置，然后翻转。
        int len = arr.length;

        List<Integer> ansList = new ArrayList<>();
        for (int end = len - 1; end >= 1; end--) {
            int maxIndex = -1;
            int maxVal = 0;
            for (int i = 0; i <= end; i++) {
                if (arr[i] > maxVal) {
                    maxVal = arr[i];
                    maxIndex = i;
                }
            }

            if (maxIndex == end) {
                continue;
            }

            ansList.add(maxIndex+1);
            ansList.add(end+1);
            int left = 0;
            int right = maxIndex;
            while (left < right) {
                swap(arr, left++, right--);
            }

            left = 0;
            right = end;
            while (left < right) {
                swap(arr, left++, right--);
            }

        }

        return ansList;
    }

}
