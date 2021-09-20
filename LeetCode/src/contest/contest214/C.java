package contest.contest214;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    private void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    public int maxProfit(int[] arr, int orders) {
        sortDesc(arr);
        int len = arr.length;

        long count = 1;
        long ans = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                long leftCount = count * (arr[i - 1] - arr[i]);
                if (orders <= leftCount) {
                    long mod = orders % count;
                    long idx = orders / count;
                    long l = arr[i - 1];
                    long h = arr[i - 1] - idx + 1;
                    ans = (ans + (l + h) * idx / 2 * count) % MOD;
                    orders -= count * idx;
                    if (mod != 0) {
                        ans = (ans + orders * (h - 1)) % MOD;
                    }
                    orders = 0;
                    break;
                } else {
                    long l = arr[i - 1];
                    long h = arr[i] + 1;

                    ans = (ans + (l + h) * (arr[i - 1] - arr[i]) * count / 2) % MOD;
                    orders -= (arr[i - 1] - arr[i]) * count;
                }
                count++;
            }
        }

        long mod = orders % count;
        long idx = orders / count;
        long l = arr[len - 1];
        long h = arr[len - 1] - idx + 1;
        ans = (ans + (l + h) * idx / 2 * count) % MOD;
        orders -= count * idx;
        if (mod != 0) {
            ans = (ans + orders * (h - 1)) % MOD;
        }
        orders = 0;

        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new C().maxProfit(new int[]{2, 5}, 4));
    }

}
