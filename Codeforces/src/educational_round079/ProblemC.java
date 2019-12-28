package educational_round079;

import java.util.Scanner;

public class ProblemC {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while ((t--) > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }

            long ans = 0;
            int from = 0;
            boolean[] visited = new boolean[n + 1];
            for (int i = 0; i < m; ) {
                for (int j = from; j < n; j++) {
                    visited[a[j]] = true;
                    if (a[j] == b[i]) {
                        ans += (j - i) * 2 + 1;
                        from = j + 1;
                        break;
                    }
                }

                int k;
                for (k = i + 1; k < m; k++) {
                    if (!visited[b[k]]) {
                        break;
                    }
                }

                if (k == m) {
                    ans += (m - i - 1);
                    break;
                }

                ans += k - i - 1;
                i = k;
            }
            
            System.out.println(ans);
        }
    }
    
}
