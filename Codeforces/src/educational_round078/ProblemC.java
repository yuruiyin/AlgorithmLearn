package educational_round078;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {

    private int getRes(int[] arr) {
        int len = arr.length;
        int n = len / 2;
        int[] prefixDiff = new int[n+1];
        int[] suffixDiff = new int[n+1];

        for (int i = 0; i < n; i++) {
            prefixDiff[i+1] = prefixDiff[i] + (arr[i] == 1 ? 1 : -1);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixDiff[i] = suffixDiff[i+1] + (arr[n + i] == 1 ? -1 : 1);
        }

        int[] rightestPos = new int[2 * n + 1];
        Arrays.fill(rightestPos, -1);
        for (int i = 0; i <= n; i++) {
            rightestPos[n + prefixDiff[i]] = i;
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (rightestPos[n + suffixDiff[i]] == -1) {
                continue;
            }
            ansMin = Math.min(ansMin, n + i - rightestPos[n + suffixDiff[i]]);
        }

        return ansMin == Integer.MAX_VALUE ? 2 * n : ansMin;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ((t--) > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println(new ProblemC().getRes(arr));
        }
    }
    
}
