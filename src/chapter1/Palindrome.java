package chapter1;

/**
 * 判断字符串是否是回文串
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aabaa"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abbab"));
    }

}
