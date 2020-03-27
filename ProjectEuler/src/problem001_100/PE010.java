package problem001_100;

/**
 * PE010
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE010 {

    // 快速求n以内的所有素数
    private long solve(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new PE010().solve(2000000));
        System.out.println(new PE010().solve(10));
    }

}
