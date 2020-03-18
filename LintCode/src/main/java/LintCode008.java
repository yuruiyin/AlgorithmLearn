/**
 * LinkCode008
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode008 {

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }

        offset %= str.length;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }

}
