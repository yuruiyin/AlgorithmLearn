package doubleContest.round28;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/13
 */
public class A {

    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int diff = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    diff = prices[j];
                    break;
                }
            }

            ansArr[i] = prices[i] - diff;
        }

        return ansArr;
    }

}
