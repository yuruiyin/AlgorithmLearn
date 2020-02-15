package lcof;

public class Lcof058_1 {

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

    private char[] getArr(String s) {
        char[] arr = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = arr.length;

        // 单词之间只保留一个空格
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ' && arr[i-1] == ' ') {
                continue;
            }
            sb.append(arr[i]);
        }

        return sb.toString().toCharArray();
    }

    public String reverseWords(String s) {
        // 两次翻转即可
        char[] arr = getArr(s);
        int len = arr.length;

        reverse(arr, 0, len - 1);
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == ' ') {
                reverse(arr, left, i - 1);
                left = i + 1;
            }
        }
        reverse(arr, left, len - 1);

        return new String(arr);
    }

}
