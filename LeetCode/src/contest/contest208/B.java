package contest.contest208;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/27
 */
public class B {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        //模拟
        int max = -1;
        int sum = 0;
        int pre = 0;
        int ans = -1;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i];
            if (sum >= 4) {
                pre += 4;
                sum -= 4;
            } else {
                pre += sum;
                sum = 0;
            }
            int cost = pre * boardingCost - runningCost * (i + 1);
            if (cost > max) {
                max = cost;
                ans = i + 1;
            }
        }

        int index = customers.length;
        while (sum > 0) {
            if (sum >= 4) {
                pre += 4;
                sum -= 4;
            } else {
                pre += sum;
                sum = 0;
            }
            int cost = pre * boardingCost - runningCost * (index + 1);
            if (cost > max) {
                max = cost;
                ans = index + 1;
            }
            index++;
        }

        return ans;
    }

}
