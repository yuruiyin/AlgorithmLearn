package problem101_200;

public class Problem125 {

    private boolean isMatch(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        String newStr = s.toLowerCase();
        char[] arr = newStr.toCharArray();

        while (left < right) {
            while (left < right && !isMatch(arr[left])) {
                left++;
            }

            if (left == right) {
                return true;
            }

            while (right > left && !isMatch(arr[right])) {
                right--;
            }

            if (left == right) {
                return true;
            }

            if (arr[left] != arr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
    public static void main(String[] args) {

    }
    
}
