package problem801_900;

public class Problem848 {

    public String shiftingLetters(String str, int[] shifts) {
        int len = shifts.length;
        long[] suffixArr = new long[len];

        suffixArr[len - 1] = shifts[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            suffixArr[i] = suffixArr[i+1] + shifts[i];
        }

        char[] arr = str.toCharArray();
        for (int i = 0; i < len; i++) {
            arr[i] = (char) ((arr[i] - 'a' + suffixArr[i]) % 26 + 'a');
        }

        return new String(arr);
    }

}
