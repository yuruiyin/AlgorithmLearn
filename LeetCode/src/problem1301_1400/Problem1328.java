package problem1301_1400;

public class Problem1328 {

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

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private String getMinStr(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return str1;
        }

        return str2;
    }

    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        int len = arr.length;
        String ans = "";

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            for (int j = 0; j < 26; j++) {
                if (j + 'a' == c) {
                    continue;
                }

                arr[i] = (char) (j + 'a');
                if (!isPalindrome(arr)) {
                    if (ans.equals("")) {
                        ans = new String(arr);
                    } else {
                        ans = getMinStr(ans, new String(arr));
                    }
                }
                arr[i] = c;
            }
        }

        return ans;
    }

}
