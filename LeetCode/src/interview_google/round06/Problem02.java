package interview_google.round06;

public class Problem02 {

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        int i = 0;
        long sum = 0;
        while (true) {
            i++;
            sum += (9 * Math.pow(10, i - 1) * i);
            if (n <= sum) {
                int curBitCount = i; // 当前位数
                int last = 0;  // 9, 99, 999
                while ((--i) > 0) {
                    last = last * 10 + 9;
                }

                // 因为n<=9已经return，所以i不可能小于1
                long lastSum = (int) (sum -  9 * Math.pow(10, curBitCount - 1) * curBitCount);
                long diff = n - lastSum;
                if (diff == 0) {
                    // 说明上一个999..9 的个位数就是结果
                    return 9;
                }

                int num = (int) (last + 1 + (diff - 1) / curBitCount);
                int indexInNum = (int) ((diff-1) % curBitCount);
                int rightMoveCount = curBitCount - indexInNum - 1;
                int res = num % 10;
                while (rightMoveCount > 0) {
                    num /= 10;
                    res = num % 10;
                    rightMoveCount--;
                }

                return res;
            }
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem02().findNthDigit(3));
        System.out.println(new Problem02().findNthDigit(14));
        System.out.println(new Problem02().findNthDigit(15));
        System.out.println(new Problem02().findNthDigit(2889));
        System.out.println(new Problem02().findNthDigit(10000));
        System.out.println(new Problem02().findNthDigit(1000000000));

    }
    
}
