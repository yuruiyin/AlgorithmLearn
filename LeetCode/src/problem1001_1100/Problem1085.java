package problem1001_1100;

public class Problem1085 {

    public int sumOfDigits(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        int sum = 0;
        while (min > 0) {
            sum += (min % 10);
            min /= 10;
        }

        return (sum & 1) ^ 1;
    }
    
    public static void main(String[] args) {

    }
    
}
