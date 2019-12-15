package problem201_300;

public class Problem214 {

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
        // 其实就是求以第一个字符开始的最长回文串（一个字符本身也算）
        char[] arr = s.toCharArray();
        int n = arr.length;

        int right = n;
        while (true) {
            int left = 0;
            right--;
            if (isPalindrome(arr, left, right)) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > right; i--) {
            sb.append(arr[i]);
        }

        sb.append(s);
        return sb.toString();
    }

}
