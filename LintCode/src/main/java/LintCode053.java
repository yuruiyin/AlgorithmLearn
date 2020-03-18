/**
 * LintCode053
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode053 {

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
        String str = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.charAt(i) == ' ' && str.charAt(i - 1) == ' ') {
                continue;
            }
            sb.append(c);
        }

        char[] arr = sb.toString().toCharArray();
        reverse(arr, 0, arr.length - 1);

        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }

        reverse(arr, start, arr.length - 1);
        return new String(arr);
    }

}
