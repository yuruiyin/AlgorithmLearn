package contest.contest199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/26
 */
public class D {

    private Map<String, Integer> memoMap;

    private int getLen(String s) {
        int ans = 0;
        int len = s.length();
        int continueCount = 1;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (continueCount == 1) {
                    ans++;
                } else if (continueCount >= 10) {
                    ans += 3;
                } else {
                    ans += 2;
                }

                continueCount = 1;
            } else {
                continueCount++;
            }
        }

        if (continueCount == 1) {
            ans++;
        } else if (continueCount < 10) {
            ans += 2;
        } else if (continueCount < 100) {
            ans += 3;
        } else {
            ans += 4;
        }

        return ans;
    }

    private int dp(String s, int k) {
        if (k == 0) {
            return getLen(s);
        }

        if (memoMap.containsKey(s)) {
            return memoMap.get(s);
        }

        int len = s.length();

        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                ansMin = Math.min(ansMin, dp(s.substring(0, i) + s.substring(i + 1), k - 1));
            }
        }

        ansMin = Math.min(ansMin, dp(s.substring(0, len - 1), k - 1));
        memoMap.put(s, ansMin);
        return ansMin;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        if (s.length() == k) {
            return 0;
        }

        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        while (k > 0) {
            int size = list.size();

            // 删单独的一个
            int removeIndex = -1;
            for (int i = 0; i < size; i++) {
                if (i == 0 && list.get(i) != list.get(i+1)) {
                    removeIndex = i;
                    break;
                }

                if (i == size - 1 && list.get(i) != list.get(i - 1)) {
                    removeIndex = i;
                    break;
                }

                if (i != 0 && i != size - 1 && list.get(i) != list.get(i-1) && list.get(i) != list.get(i + 1)) {
                    removeIndex = i;
                    break;
                }
            }

            if (removeIndex == -1) {
                break;
            }

            list.remove(removeIndex);
            k--;
        }

        memoMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return dp(sb.toString(), k);

    }

}
