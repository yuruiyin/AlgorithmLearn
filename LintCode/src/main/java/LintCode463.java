import java.util.Arrays;

/**
 * LintCode463
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode463 {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sortIntegers(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

}
