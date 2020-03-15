package problem601_700;

import java.util.Arrays;
import java.util.List;

public class Problem638 {

    private int[] memo;
    private List<Integer> price;
    private List<List<Integer>> giftList;
    private int needSize;

    private int dp(int[] needArr) {
        int needs = listToInt(needArr);
        if (needs == 0) {
            return 0;
        }

        if (memo[needs] != -1) {
            return memo[needs];
        }

        // 从礼包或单品中选一个，但是数量不能超出需要的数量
        int minCost = Integer.MAX_VALUE;
        for (List<Integer> gift : giftList) {
            boolean isOk = true;
            for (int j = 0; j < gift.size() - 1; j++) {
                if (gift.get(j) > needArr[j]) {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) {
                continue;
            }

            int[] nextNeedArr = Arrays.copyOf(needArr, needSize);
            for (int j = 0; j < gift.size() - 1; j++) {
                nextNeedArr[j] -= gift.get(j);
            }

            int cost = gift.get(gift.size() - 1) + dp(nextNeedArr);
            minCost = Math.min(minCost, cost);
        }

        if (minCost == Integer.MAX_VALUE) {
            // 说明没有礼包可以满足要求了，则直接选择单品的价格购买即可
            int cost = 0;
            for (int i = 0; i < needSize; i++) {
                cost += needArr[i] * price.get(i);
            }

            memo[needs] = cost;
            return cost;
        }

        // 选单品
        for (int i = 0; i < needSize; i++) {
            int count = needArr[i];
            if (count != 0) {
                needArr[i]--;
                int cost = price.get(i) + dp(needArr);
                needArr[i]++;
                minCost = Math.min(minCost, cost);
            }
        }

        memo[needs] = minCost;
        return minCost;
    }

    private int listToInt(int[] needs) {
        int intNeeds = 0;
        int size = needs.length;
        for (int i = 0; i < size; i++) {
            intNeeds *= 10;
            intNeeds += needs[i];
        }
        return intNeeds;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.giftList = special;
        needSize = needs.size();
        int[] needArr = new int[needSize];
        for (int i = 0; i < needSize; i++) {
            needArr[i] = needs.get(i);
        }

        int maxNeeds = (int) Math.pow(10, needSize);
        memo = new int[maxNeeds];
        Arrays.fill(memo, -1);
        return dp(needArr);
    }

}
