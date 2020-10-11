package contest.contest210;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/11
 */
public class C {

    private boolean isPalindrome(char[] arr, int from, int to) {
        int left = from;
        int right = to;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isOk(char[] arr1, char[] arr2) {
        int len = arr1.length;
        int pivot = -1;
        for (int i = 0; ; i++) {
            if (arr1[i] != arr2[len - i - 1]) {
                break;
            }
            pivot = i;
        }

        if (pivot == -1) {
            return false;
        }

        return isPalindrome(arr2, pivot + 1, len - pivot - 2) || isPalindrome(arr1, pivot + 1, len - pivot - 2);
    }

    public boolean checkPalindromeFormation(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int len = arr1.length;
        boolean isPalindrome1 = isPalindrome(arr1, 0, len - 1);
        boolean isPalindrome2 = isPalindrome(arr2, 0, len - 1);
        if (isPalindrome1 || isPalindrome2) {
            return true;
        }

        return isOk(arr1, arr2) || isOk(arr2, arr1);
    }
    
    public static void main(String[] args) {
//        "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd"
//        "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"
//        System.out.println(new C().checkPalindromeFormation("ulacfd",  "jizalu"));
        System.out.println(new C().checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd",  "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }

}
