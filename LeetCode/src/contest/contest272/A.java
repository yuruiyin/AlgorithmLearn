package contest.contest272;

/**
 * A
 *
 * @author: yry
 * @date: 2021/12/19
 */
public class A {

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

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            char[] arr = word.toCharArray();
            if (isPalindrome(arr, 0, arr.length - 1)) {
                return word;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
