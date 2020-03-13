package problem601_700;

public class Problem680 {

    private boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        // 从两边向中间遍历，若出现不相等则删除其中一个
        char[] arr = s.toCharArray();
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                // 分两种情况
                // 删左边
                return isPalindrome(arr, left + 1, right) || isPalindrome(arr, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

}
