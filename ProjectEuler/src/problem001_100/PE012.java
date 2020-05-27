package problem001_100;

/**
 * PE012
 *
 * @author: yry
 * @date: 2020/5/22
 */
public class PE012 {

    private long getPreSum(long n) {
        return n * (n + 1) / 2;
    }

    private int getFactorCount(long num) {
        int count = 2;

        for (long i = 2; i * i < num; i++) {
            if (num % i == 0) {
                count += 2;
            }
        }

        long sqrt = (long) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            count++;
        }
        return count;
    }

    private long solve(int n) {
        for (int i = 1; ;i++) {
            long preSum = getPreSum(i);
            int count = getFactorCount(preSum);
            if (count >= n) {
                return preSum;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new PE012().solve(500));
    }
    
}
