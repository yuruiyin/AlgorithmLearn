package contest.contest298;

public class C {

    public int longestSubsequence(String s, int k) {
        // 从0个1到logk个1
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] preZeroCountArr = new int[len];
        preZeroCountArr[0] = arr[0] == '0' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            preZeroCountArr[i] = preZeroCountArr[i -  1] + (arr[i] == '0' ? 1 : 0);
        }

        int maxCount = preZeroCountArr[len - 1];
        for (int i = 0; i < len; i++) {
            if (arr[i] == '1') {
                int value = 1;
                int count = 1;
                for (int j = i + 1; j < len; j++) {
                    if (value * 2 + (arr[j] - '0') > k) {
                        continue;
                    }
                    value <<= 1;
                    value += (arr[j] - '0');
                    count++;
                }
                maxCount = Math.max(maxCount, count + ((i == 0) ? 0 : preZeroCountArr[i - 1]));
            }
        }
        return maxCount;
    }

}
