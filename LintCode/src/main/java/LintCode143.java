/**
 * LintCode143
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode143 {

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

        arr[start] = arr[left];
        arr[left] = pivot;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public void sortColors2(int[] colors, int k) {
        // write your code here
        quickSort(colors, 0, colors.length - 1);
    }

}
