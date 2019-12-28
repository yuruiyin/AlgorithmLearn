package educational_round079;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemF {

    private static boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int l = scanner.nextInt();
            String s = scanner.next();
            char[] arr = s.toCharArray();
            int[] upperCount = new int[n - l + 1];

            for (int j = 0; j < l; j++) {
                upperCount[0] += isUpper(arr[j]) ? 1 : 0;
            }

            for (int i = 1; i <= n - l; i++) {
                upperCount[i] = upperCount[i-1] - (isUpper(arr[i-1]) ? 1 : 0) + (isUpper(arr[i + l - 1]) ? 1 : 0);
            }

            int totalUpperCount = 0;
            for (char c : arr) {
                if (isUpper(c)) {
                    totalUpperCount++;
                }
            }


            Arrays.sort(upperCount);
            int oldTotalUpperCount = totalUpperCount;
            for (int i = 0; i < k; i++) {
                totalUpperCount -= upperCount[i];
            }

            int min1 = Math.min(totalUpperCount, n - totalUpperCount);

            for (int i = n - l; i > n - l - k; i--) {
                oldTotalUpperCount -= upperCount[i];
            }

            int min2 = Math.min(oldTotalUpperCount, n - oldTotalUpperCount);

            System.out.println(Math.min(min1, min2));
        }

    }

}
