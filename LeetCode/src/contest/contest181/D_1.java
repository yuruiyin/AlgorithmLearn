package contest.contest181;

/**
 * D_1
 *
 * @author: yry
 * @date: 2020/3/22
 */
public class D_1 {

    private boolean isEqual(char[] arr, int r1, int l2) {
        int len = r1 + 1;
        for (int i = 0; i < len; i++) {
            if (arr[i] != arr[l2 + i]) {
                return false;
            }
        }
        return true;
    }

    public String longestPrefix(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            if (isEqual(arr, i, len - i - 1)) {
                return s.substring(0, i + 1);
            }
        }

        return "";
    }

}
