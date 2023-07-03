package contest.contest340;

public class A {

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int ansMaxPrime = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (isPrime(nums[i][i])) {
                ansMaxPrime = Math.max(ansMaxPrime, nums[i][i]);
            }
            if (isPrime(nums[i][len - i - 1])) {
                ansMaxPrime = Math.max(ansMaxPrime, nums[i][len - i - 1]);
            }
        }
        return ansMaxPrime;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
