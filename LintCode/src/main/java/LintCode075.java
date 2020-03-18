/**
 * LintCode075
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode075 {

    public int findPeak(int[] arr) {
        // write your code here
        int len = arr.length;
        if (len == 3) {
            return 1;
        }

        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new LintCode075().findPeak(new int[]{1, 2, 3, 1}));
    }

}
