package contest.contest334;

public class B {

    public int[] divisibilityArray(String word, int m) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        int[] ansArr = new int[len];
        long pre = 0;
        for (int i = 0; i < len; i++) {
            pre = pre * 10 + arr[i] - '0';
            if (pre % m == 0) {
                ansArr[i] = 1;
            } else {
                ansArr[i] = 0;
            }
            pre %= m;
        }
        return ansArr;
    }

}
