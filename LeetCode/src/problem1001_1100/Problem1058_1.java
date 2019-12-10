package problem1001_1100;

import java.util.Arrays;

public class Problem1058_1 {

    public String minimizeError(String[] prices, int target) {
        int len = prices.length;
        double[] priceArr = new double[len];

        for (int i = 0; i < len; i++) {
            priceArr[i] = Double.parseDouble(prices[i]);
            int intPart = (int) Math.floor(priceArr[i]);
            priceArr[i] -= intPart;
            target -= intPart;
        }

        if (target > len || target < 0) {
            return String.valueOf(-1);
        }

        // 从大到小排序，前几项变为1，后几项变为0
        Arrays.sort(priceArr);

        double onePart = 0;
        int index = len - 1;

        while ((target--) > 0) {
            if (priceArr[index] == 0) {
                return String.valueOf(-1);
            }
            onePart += 1 - priceArr[index--];
        }

        double zeroPart = 0;
        while (index >= 0) {
            zeroPart += priceArr[index--];
        }

        // 保留3位小数
        return String.format("%.3f", onePart + zeroPart);
    }

}
