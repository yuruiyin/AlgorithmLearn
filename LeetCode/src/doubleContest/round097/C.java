package doubleContest.round097;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {

    public int maximizeWin(int[] prizePositions, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = prizePositions.length;
        list.add(prizePositions[0]);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (prizePositions[i] == prizePositions[i - 1]) {
                count++;
            } else {
                countMap.put(prizePositions[i-1], count);
                list.add(prizePositions[i]);
                count = 1;
            }
        }

        countMap.put(prizePositions[len - 1], count);
        int size = list.size();
        int[] dp = new int[size];
        int[] rArr = new int[size];
        int r = -1;
        for (int i = 0; i < size; i++) {
            int l = list.get(i);
            int max = l + k;
            int value = 0;
            for (int j = r == -1 ? i : r + 1; j < size; j++) {
                if (list.get(j) > max) {
                    break;
                }
                r = j;
                value += countMap.getOrDefault(list.get(j), 0);
            }

            rArr[i] = r;
            if (i == 0) {
                dp[i] = value;
            } else {
                int pre = countMap.getOrDefault(list.get(i - 1), 0);
                dp[i] = dp[i - 1] - pre + value;
            }
        }

        int[] rightMaxArr = new int[size];
        rightMaxArr[size - 1] = dp[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], dp[i]);
        }

        int ansMax = 0;
        for (int i = 0; i < size; i++) {
            int rIdx = rArr[i];
            ansMax = Math.max(ansMax, dp[i] + (rIdx == size - 1 ? 0 : rightMaxArr[rIdx + 1]));
        }
        return ansMax;
    }

}
