package doubleContest.round075;

public class A {

    public int minBitFlips(int start, int goal) {
        String startStr = Integer.toBinaryString(start);
        String goalStr = Integer.toBinaryString(goal);
        char[] arr1 = startStr.toCharArray();
        char[] arr2 = goalStr.toCharArray();
        int maxLen = Math.max(arr1.length, arr2.length);
        int ans = 0;
        for (int i = 0; i < maxLen; i++) {
            int idx1 = arr1.length - i - 1;
            int idx2 = arr2.length - i - 1;
            if (idx1 < 0) {
                if (arr2[idx2] == '1') {
                    ans++;
                }
            } else if (idx2 < 0) {
                if (arr1[idx1] == '1') {
                    ans++;
                }
            } else {
                if (arr1[idx1] != arr2[idx2]) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
