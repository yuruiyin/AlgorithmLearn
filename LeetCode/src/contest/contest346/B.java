package contest.contest346;

public class B {

    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                char min = (char) Math.min(arr[l], arr[r]);
                arr[l] = min;
                arr[r] = min;
            }
            l++;
            r--;
        }
        return new String(arr);
    }

}
