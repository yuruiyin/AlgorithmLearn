package contest.contest346;

import java.util.HashMap;
import java.util.Map;

public class C {

    private final static Map<Integer, Boolean> memoMap = new HashMap<>();

    private boolean isOk(int num, int target) {
        if (num == target) {
            return true;
        }

        if (num == 0) {
            return false;
        }

        if (target <= 0) {
            return false;
        }

        int key = num * 1000 + target;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        boolean res = false;
        int sum = 0;
        int flag = 1;
        while (num > 0) {
            sum += (num % 10) * flag;
            if (isOk(num / 10, target - sum)) {
                res = true;
                break;
            }
            num /= 10;
            flag *= 10;
        }

        memoMap.put(key, res);
        return res;
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            if (isOk(num , i)) {
                ans += num;
            }
        }
        return ans;
    }

}
