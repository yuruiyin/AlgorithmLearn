package contest.contest233;

import java.util.TreeMap;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/21
 */
public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int getNumberOfBacklogOrders(int[][] orders) {
        // orders[i] = [pricei, amounti, orderTypei]
//        0 表示这是一批采购订单 buy
//        1 表示这是一批销售订单 sell

        TreeMap<Integer, Integer> buyCountMap = new TreeMap<>();
        TreeMap<Integer, Integer> sellCountMap = new TreeMap<>();

        int len = orders.length;
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if (type == 0) {
                // buy
                while (!sellCountMap.isEmpty()) {
                    int min = sellCountMap.firstKey();
                    if (min > price) {
                        break;
                    }

                    int sellCount = sellCountMap.get(min);
                    if (sellCount >= amount) {
                        sellCountMap.put(min, sellCount - amount);
                        amount = 0;
                        break;
                    } else {
                        sellCountMap.pollFirstEntry();
                        amount -= sellCount;
                    }
                }

                buyCountMap.put(price, buyCountMap.getOrDefault(price, 0) + amount);
            } else {
                while (!buyCountMap.isEmpty()) {
                    int max = buyCountMap.lastKey();
                    if (max < price) {
                        break;
                    }

                    int buyCount = buyCountMap.get(max);
                    if (buyCount >= amount) {
                        buyCountMap.put(max, buyCount - amount);
                        amount = 0;
                        break;
                    } else {
                        buyCountMap.pollLastEntry();
                        amount -= buyCount;
                    }
                }

                sellCountMap.put(price, sellCountMap.getOrDefault(price, 0) + amount);
            }
        }

        int ansCount = 0;
        while (!buyCountMap.isEmpty()) {
            ansCount = (ansCount + buyCountMap.pollFirstEntry().getValue()) % MOD;
        }

        while (!sellCountMap.isEmpty()) {
            ansCount = (ansCount + sellCountMap.pollFirstEntry().getValue()) % MOD;
        }

        return ansCount;
    }

}
