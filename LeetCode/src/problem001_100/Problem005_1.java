package problem001_100;

public class Problem005_1 {

    /*
                           _ooOoo_
                          o8888888o
                          88" . "88
                          (| -_- |)
                          O\  =  /O
                       ____/`---'\____
                     .'  \\|     |//  `.
                    /  \\|||  :  |||//  \
                   /  _||||| -:- |||||-  \
                   |   | \\\  -  /// |   |
                   | \_|  ''\---/''  |   |
                   \  .-\__  `-`  ___/-. /
                 ___`. .'  /--.--\  `. . __
              ."" '<  `.___\_<|>_/___.'  >'"".
             | | :  `- \`.;`\ _ /`;.`/ - ` : | |
             \  \ `-.   \_ __\ /__ _/   .-` /  /
        ======`-.____`-.___\_____/___.-`____.-'======
                           `=---='
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                 佛祖保佑       永无BUG
    */

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

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        char[] arr = s.toCharArray();
        int ansStart = 0;
        int ansEnd = 0;
        int maxLen = 1;

        for (int left = 0; left < n - maxLen; left++) {
            for (int right = n-1; right >= left + maxLen; right--) {
                if (isPalindrome(arr, left, right)) {
                    int len = right - left + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        ansStart = left;
                        ansEnd = right;
                    }

                    break;
                }
            }
        }

        return s.substring(ansStart, ansEnd + 1);
    }

}
