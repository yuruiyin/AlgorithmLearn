package problem101_200;

/**
 * Problem151_1
 *
 * @author: yry
 * @date: 2020/4/10
 */
public class Problem151_1 {

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();
        int len = arr.length;
        reverse(arr, 0, len - 1);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ' && arr[i - 1] != ' ') {
                for (int j = i - 1; j >= start; j--) {
                    sb.append(arr[j]);
                }
                sb.append(' ');
            } else if (i > 0 && arr[i - 1] == ' ') {
                start = i;
            }
        }

        for (int i = len - 1; i >= start; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

}
