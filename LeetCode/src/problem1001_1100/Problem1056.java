package problem1001_1100;

import java.util.Arrays;

public class Problem1056 {

    public boolean confusingNumber(int n) {
        int[] map = new int[10];
        Arrays.fill(map, -1);
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[8] = 8;
        map[9] = 6;

        int oldNum = n;
        int ans = 0;
        while (n > 0) {
            int lowBit = n % 10;
            if (map[lowBit] == -1) {
                return false;
            }

            ans *= 10;
            ans += map[lowBit];
            n /= 10;
        }

        return ans != oldNum;
    }

}
