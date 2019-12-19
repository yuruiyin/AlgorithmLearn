package problem201_300;

public class Problem263 {

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        if (num <= 5) {
            return true;
        }

        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                if (i > 5 && isPrime(i) || num / i > 5 && isPrime(num / i)) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem263().isUgly(-2147483648));
    }

}
