package doubleContest.round074;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/19
 */
public class B {

    public long maximumSubsequenceCount(String text, String pattern) {
        char[] arr = text.toCharArray();
        int len = arr.length;
        int[] preCountArr = new int[len];
        preCountArr[0] = arr[0] == pattern.charAt(0) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] == pattern.charAt(0)) {
                preCountArr[i] = preCountArr[i - 1] + 1;
            } else {
                preCountArr[i] = preCountArr[i - 1];
            }
        }

        long ans1 = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == pattern.charAt(1)) {
                ans1 += (i == 0 ? 1 : preCountArr[i - 1] + 1);
            }
        }

        int[] sufCountArr = new int[len];
        sufCountArr[len - 1] = pattern.charAt(1) == arr[len - 1] ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == pattern.charAt(1)) {
                sufCountArr[i] = sufCountArr[i + 1] + 1;
            } else {
                sufCountArr[i] = sufCountArr[ i + 1];
            }
        }

        long ans2 = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == pattern.charAt(0)) {
                ans2 += (i == len - 1 ? 1 : sufCountArr[i + 1] + 1);
            }
        }

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
