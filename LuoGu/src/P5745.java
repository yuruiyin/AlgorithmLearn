import java.util.Scanner;

public class P5745 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }

        int left = 0;
        int right = 0;
        int ansLeft = 0;
        int ansRight = 0;
        long ansSum = 0;
        long sum = 0;
        while (right < n) {
            while (right < n) {
                if (sum + arr[right] <= (long) m) {
                    sum += arr[right];
                    right++;
                } else {
                    break;
                }
            }

            if (sum > ansSum) {
                ansSum = sum;
                ansLeft = left;
                ansRight = right - 1;
            }

            if (right == n) {
                break;
            }

            sum -= arr[left];
            left++;
            if (right < left) {
                right++;
                sum = 0;
            }
        }

        System.out.println((ansLeft + 1) + " " + (ansRight + 1) + " " + ansSum);
    }
    
}
