package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuaweiTest2 {

    private int[] countToWeightMap;

    private boolean hasAfterFive(int[] countArr, int from) {
        for (int i = from + 1; i <= from + 4; i++) {
            if (countArr[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private int dp(int[] countArr, int from) {
        if (from == 15) {
            return 0;
        }

        if (countArr[from] == 0) {
            return dp(countArr, from + 1);
        }

        int oldCount = countArr[from];
        countArr[from] = 0;
        int nonChooseRes = countToWeightMap[oldCount] + dp(countArr, from + 1); // 不归顺子的结果
        countArr[from] = oldCount;

        // 判断是否有顺子
        if (from > 10 || !hasAfterFive(countArr, from)) {
            return nonChooseRes;
        }

        // 有顺子，但是可选或可不选
        for (int i = from; i <= from + 4; i++) {
            countArr[i]--;
        }
        int chooseRes = dp(countArr, from) + 3;
        for (int i = from; i <= from + 4; i++) {
            countArr[i]++;
        }

        // 返回当前数字归顺子和不归顺子的最大值
        return Math.max(chooseRes, nonChooseRes);
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] countArr = new int[17];

        Map<Character, Integer> map = new HashMap<>();
        map.put('J', 11);
        map.put('Q', 12);
        map.put('K', 13);
        map.put('A', 14);

        for (int i = 0; i < n; i++) {
            String card = scanner.next();
            if (card.equals("J1")) {
                countArr[15]++;
            } else if (card.equals("J2")) {
                countArr[16]++;
            } else {
                if (card.length() == 3) {
                    // 10
                    countArr[10]++;
                } else {
                    char num = card.charAt(1);
                    if (num >= '2' && num <= '9') {
                        countArr[num - '0']++;
                    } else {
                        countArr[map.get(num)]++;
                    }
                }
            }
        }

        int ans = 0;
        if (countArr[15] != 0 && countArr[16] != 0) {
            ans += 5;
        }

        countToWeightMap = new int[]{0, 0, 2, 4, 5};
        ans += dp(countArr, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new HuaweiTest2().solve();
    }

}
