package doubleContest.round075;

public class C {

    public long numberOfWays(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        long[] preOneCountArr = new long[len];
        preOneCountArr[0] = arr[0] - '0';
        long totalOneCount = 0;
        for (char c : arr) {
            totalOneCount += c - '0';
        }
        for (int i = 1; i < len; i++) {
            preOneCountArr[i] = preOneCountArr[i - 1] + (arr[i] - '0');
        }
        long ans = 0;
        for (int i = 1; i < len - 1; i++) {
            if (arr[i] == '0') {
                ans += preOneCountArr[i] * (totalOneCount - preOneCountArr[i]);
            } else {
                ans += (i + 1 - preOneCountArr[i]) * (len - i - 1 - (totalOneCount - preOneCountArr[i]));
            }
        }
        return ans;
    }

}
