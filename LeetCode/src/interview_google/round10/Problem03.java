package interview_google.round10;

public class Problem03 {

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansEnd = 0;

        if (len == 0) {
            return "";
        }

        for (int end = len - 1; end >= 0; end--) {
            if (isPalindrome(arr, 0, end)) {
                ansEnd = end;
                break;
            }
        }

        if (ansEnd == len - 1) {
            return s;
        }

        String rightStr = s.substring(ansEnd + 1, len);
        return new StringBuilder(rightStr).reverse() + s.substring(0, ansEnd + 1) + rightStr;
    }

}
