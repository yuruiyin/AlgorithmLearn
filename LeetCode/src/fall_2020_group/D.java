package fall_2020_group;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/19
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);
    private Map<String, Long> memo;

    private long rec(int n, char[] arr) {
        if (n == 0) {
            return 1;
        }

        String key = new String(arr) + "_" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long ans = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != '0') {
                arr[i]--;
                ans = (ans +  rec(n - 1, arr)) % MOD;
                arr[i]++;
            }
        }

        memo.put(key, ans);
        return ans;
    }

    public int keyboard(int k, int n) {
        char[] arr = new char[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = (char) (k + '0');
        }

        memo = new HashMap<>();
        return (int) (rec(n, arr) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new D().keyboard(1, 1));
        System.out.println(new D().keyboard(1, 2));
        System.out.println(new D().keyboard(5, 5));
    }

}
