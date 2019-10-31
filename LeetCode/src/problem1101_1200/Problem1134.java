package problem1101_1200;

public class Problem1134 {

    public boolean isArmstrong(int n) {
        int sum = 0;
        String num = String.valueOf(n);
        int k = num.length();
        int oldN = n;
        while (n > 0) {
            int value = n % 10;
            sum += Math.pow(value, k);
            n /= 10;
        }

        return sum == oldN;
    }
    
    public static void main(String[] args) {
        
    }
    
}
