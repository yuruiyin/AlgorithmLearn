package problem501_600;

public class Problem541 {

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int start = 0; start < len; start += 2*k) {
            int end = Math.min(len - 1, start + k - 1);
            reverse(arr, start, end);
        }

        return new String(arr);
    }

}
