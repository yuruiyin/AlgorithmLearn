package round609;

import java.util.Scanner;

public class ProblemD {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            int[] countArr = new int[300001];

            for (int i = 0; i < n; i++) {
                countArr[arr[i]]++;
            }

            long ans = 0;
            int value = 0;
            int maxN = n;
            int i;
            for (i = 0; i < n - 1; i++) {
                if (arr[i] - value == 0) {
                    break;
                }

                int diff = arr[i] - arr[i+1];
                if (diff % 2 == 0) {
                    ans += diff / 2;
                    ans += arr[i+1] - value;
                    i++;
                } else {
                    ans += (arr[i] - value) / 2;
                    if ((arr[i] - value) % 2 == 1) {
                        ans += (maxN - i) / 2;
                        value++;
                        maxN -= countArr[value];
                    }
                }
            }

            ans += (arr[i] - value) / 2;
            System.out.println(ans);
        }
    }
    
}
