package problem001_100;

/**
 * PE005
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE005 {

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getAllPrimeFactors(int n) {
        int[] primeCountArr = new int[n + 1];
        for (int i = 2; i <= n && n > 1; i++) {
            while (n % i == 0 && isPrime(i)) {
                primeCountArr[i]++;
                n /= i;
            }
        }

        if (isPrime(n)) {
            primeCountArr[n] = 1;
        }
        return primeCountArr;
    }

    private long solve(int n) {
        int[] primeCountArr = new int[n + 1];
        long ans = 1;
        for (int i = n; i >= 2; i--) {
            int[] curPrimeCountArr = getAllPrimeFactors(i);
            for (int j = 2; j <= i; j++) {
                if (curPrimeCountArr[j] > primeCountArr[j]) {
                    ans *= Math.pow(j, (curPrimeCountArr[j] - primeCountArr[j]));
                    primeCountArr[j] = curPrimeCountArr[j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PE005().solve(20));
        for (int i = 1; i <= 30; i++) {
            System.out.println(new PE005().solve(i));
        }
    }

}
