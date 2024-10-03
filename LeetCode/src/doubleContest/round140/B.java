package doubleContest.round140;

import java.util.Arrays;

public class B {

    public long maximumTotalSum(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        long ans = 0;
        int preNum = (int) (1e9 + 1);
        for (int i = len - 1; i >= 0; i--) {
            if (preNum <= arr[i]) {
                arr[i] = Math.min(arr[i] - 1, preNum - 1);
            }
            int leftCount = i + 1;
            if (arr[i] < leftCount) {
                return -1;
            }
            ans += arr[i];
            preNum = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        // [7,4,5,4,7,2,6]
        System.out.println(new B().maximumTotalSum(new int[]{7,4,5,4,7,2,6}));
    }

}
