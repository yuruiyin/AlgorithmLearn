package problem001_100;

public class Problem029 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == divisor) {
            return 1;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        int originDividend = dividend;

        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
        }

        boolean isNegative = false;

        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            isNegative = true;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;

        while (divisor <= dividend) {
            int tmpDivisor = divisor;
            boolean isTooBigger = false;
            int tmpCount = 1;
            while (tmpDivisor <= dividend) {
                if ((tmpDivisor << 1) < 0) {
                    isTooBigger = true;
                    break;
                }
                tmpCount = tmpCount << 1;
                tmpDivisor = tmpDivisor << 1;
            }

            if (isTooBigger) {
                dividend -= tmpDivisor;
            } else {
                tmpCount = tmpCount >> 1;
                dividend -= (tmpDivisor >> 1);
            }

            count += tmpCount;
        }

        if (originDividend == Integer.MIN_VALUE) {
            count++;
        }

        if (isNegative) {
            return -count;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problem029().divide(10, 3));
        System.out.println(new Problem029().divide(7, -3));
        System.out.println(new Problem029().divide(2, -3));
        System.out.println(new Problem029().divide(3, -3));
        System.out.println(new Problem029().divide(-2147483648, -1));
        System.out.println(new Problem029().divide(2147483647, 1));
        System.out.println(new Problem029().divide(20, 3));
        System.out.println(new Problem029().divide(-2147483648, 2));

    }
    
}
