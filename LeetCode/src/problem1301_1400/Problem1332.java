package problem1301_1400;

public class Problem1332 {

    private boolean isPalindrome(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public int removePalindromeSub(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] arr = s.toCharArray();
        if (isPalindrome(arr)) {
            return 1;
        }

        return 2;
    }

}
