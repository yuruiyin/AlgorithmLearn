package problem301_400;

public class Problem400 {

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        int i = 0; // 当前第几位
        long sum = 0;
        while (true) {
            i++;
            sum += (9 * Math.pow(10, i - 1) * i);
            if (n <= sum) {
                int curBitFirstNum = (int) Math.pow(10, i - 1);  // 10,100,1000...

                long lastSum = (int) (sum -  9 * Math.pow(10, i - 1) * i);
                long diff = n - lastSum - 1;

                int num = (int) (curBitFirstNum + diff / i);
                int indexInNum = (int) (diff % i);
                int rightMoveCount = i - indexInNum - 1;
                int res = num % 10;
                while ((rightMoveCount--) > 0) {
                    num /= 10;
                    res = num % 10;
                }

                return res;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Problem400().findNthDigit(3));
        System.out.println(new Problem400().findNthDigit(14));
        System.out.println(new Problem400().findNthDigit(15));
        System.out.println(new Problem400().findNthDigit(2889));
        System.out.println(new Problem400().findNthDigit(10000));
        System.out.println(new Problem400().findNthDigit(1000000000));

    }

}
