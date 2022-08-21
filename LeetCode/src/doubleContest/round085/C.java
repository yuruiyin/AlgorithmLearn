package doubleContest.round085;

public class C {

    public String shiftingLetters(String s, int[][] shifts) {
        // 差分
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] diff = new int[len];
        for (int[] shift : shifts) {
            int startIdx = shift[0];
            int endIdx = shift[1];
            int op = shift[2] == 0 ? -1 : 1;
            diff[startIdx] += op;
            if (endIdx + 1 < len) {
                diff[endIdx + 1] -= op;
            }
        }

        for (int i = 1; i < len; i++) {
            diff[i] += diff[i - 1];
        }

        char[] ansArr = new char[len];
        for (int i = 0; i < len; i++) {
            int newCharInt = arr[i] + (diff[i] + 26 * len) % 26;
            ansArr[i] = newCharInt > 'z' ? (char) (newCharInt - 26) : (char) newCharInt;
        }
        return new String(ansArr);
    }

}
