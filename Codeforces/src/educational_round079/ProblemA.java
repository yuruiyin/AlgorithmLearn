package educational_round079;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ((t--) > 0) {
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            int b = scanner.nextInt();

            int[] arr = new int[]{r, g, b};
            Arrays.sort(arr);

            if (arr[2] > arr[0] + arr[1] + 1) {
                System.out.println("No");
                continue;
            }

            System.out.println("Yes");
        }
    }
    
}
