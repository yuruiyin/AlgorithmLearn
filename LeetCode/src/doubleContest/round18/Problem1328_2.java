package doubleContest.round18;

public class Problem1328_2 {

    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        int len = arr.length;
        if (len == 1) {
            return "";
        }

        int end = len >>> 1;
        for (int i = 0; i < end; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[len - 1] = 'b';  // 所有都为‘a’，则将最后一个变成'b'，就是字典序最小。
        return new String(arr);
    }

}
