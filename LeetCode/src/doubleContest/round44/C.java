package doubleContest.round44;

import utils.PrintUtil;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/23
 */
public class C {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }

        for (int i = n - 2; i >= 0; i-=2) {
            sum ^= encoded[i];
        }

        int[] arr = new int[n];
        arr[0] = sum;
        for (int i = 1; i < n; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new C().decode(new int[]{3, 1});
        PrintUtil.printIntArray(arr);
    }

}
