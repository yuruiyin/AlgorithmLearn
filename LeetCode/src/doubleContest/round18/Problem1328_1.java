package doubleContest.round18;

public class Problem1328_1 {

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
                    arr[i] = c;
                    break;
                }
                arr[i] = c;
            }
        }

        return ans;
    }

}
