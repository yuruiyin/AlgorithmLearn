package educational_round079;

import java.util.Scanner;

public class ProblemB {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ((t--) > 0) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            long sum = 0;
            int max = 0;
            int maxIndex = -1;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIndex = i;
                }
                sum += arr[i];
                if (sum > s) {
                    ans = maxIndex + 1;
                    break;
                }
            }
            
            System.out.println(ans);
        }
    }
    
}
