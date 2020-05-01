package lcci;

/**
 * Lcci1616
 *
 * @author: yry
 * @date: 2020/4/17
 */
public class Lcci1616 {

    public int[] subSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }

        int len = arr.length;
        int[] preMaxArr = new int[len];
        int[] sufMinArr = new int[len];
        preMaxArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preMaxArr[i] = Math.max(preMaxArr[i - 1], arr[i]);
        }

        sufMinArr[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufMinArr[i] = Math.min(sufMinArr[i + 1], arr[i]);
        }

        int left = -1;
        int right = -1;
        for (int i = 0; i < len - 1; i++) {
            if (sufMinArr[i + 1] < arr[i]) {
                left = i;
                break;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if (preMaxArr[i - 1] > arr[i]) {
                right = i;
                break;
            }
        }

        return new int[]{left, right};
    }

}
