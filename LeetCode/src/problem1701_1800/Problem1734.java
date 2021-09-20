package problem1701_1800;

/**
 * Problem1734
 *
 * @author: yry
 * @date: 2021/5/11
 */
public class Problem1734 {

    public int[] decode(int[] encoded) {
        int sum = 0;
        int n = encoded.length + 1;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }

        for (int i = n - 2; i >= 0; i -= 2) {
            sum ^= encoded[i];
        }

        int[] arr = new int[n];
        arr[0] = sum;
        for (int i = 1; i < n; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }
        return arr;
    }

}
