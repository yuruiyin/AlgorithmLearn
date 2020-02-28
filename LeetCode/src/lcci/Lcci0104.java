package lcci;

public class Lcci0104 {

    public boolean canPermutePalindrome(String s) {
        // 回文串排列需要满足所有字符的个数中最多只有一个字符的个数为奇数，其它都为偶数
        int[] countArr = new int[128];

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                countArr[c]++;
            }
        }

        int oddCountCount = 0;

        for (int i = 0; i < 128; i++) {
            if ((countArr[i] & 1) == 1) {
                oddCountCount++;
            }

            if (oddCountCount > 1) {
                return false;
            }
        }

        return true;
    }

}
