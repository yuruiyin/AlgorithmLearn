package problem101_200;

import java.util.HashMap;
import java.util.Map;

public class Problem166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long dividend = numerator;
        long divisor = denominator;

        boolean isResNegative = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            isResNegative = true;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        StringBuilder sb = new StringBuilder();
        long intPart = dividend / divisor;

        sb.append(intPart);

        if (dividend % divisor == 0) {
            return isResNegative ? "-" + sb.toString() : sb.toString();
        }

        sb.append(".");

        dividend -= intPart * divisor;  // 此时被除数小于除数
        dividend *= 10;

        Map<Long, Integer> map = new HashMap<>();  // key为被除数，value为对应被除数除以除数的值再sb中的索引
        int cycleIndex = -1;

        while (true) {
            if (dividend % divisor == 0) {
                sb.append(dividend / divisor);
                break;
            }

            if (dividend > divisor) {
                if (map.containsKey(dividend)) {
                    cycleIndex = map.get(dividend);
                    break;
                }
                map.put(dividend, sb.length());
                long value = dividend / divisor;
                sb.append(value);
                dividend -= value * divisor;
            } else {
                sb.append(0);
            }

            dividend *= 10;
        }

        if (cycleIndex != -1) {
            sb.insert(cycleIndex, "(");
            sb.append(")");
        }

        return isResNegative ? "-" + sb.toString() : sb.toString();

    }

}
