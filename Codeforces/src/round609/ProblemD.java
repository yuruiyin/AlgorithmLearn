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
            for (i = 0; i < n; i++) {
                if (arr[i] - value <= 0) {
                    break;
                }

                if (i == n - 1 || arr[i+1] - value <= 0) {
                    ans += (arr[i] - value) / 2;
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
                        if ((maxN - i) % 2 == 0) {
                            ans += (maxN - i) / 2;
                            value++;
                            maxN -= countArr[value];
                        } else if (i + 1 < n - 1 && arr[i+1] > arr[i+2]) {
                            // 看下一个是不是比下下个多，如果是的话，底部横向算一个，下一个值减一
                            ans++;
                            arr[i+1]--;
                        }
                    }
                }
            }

            System.out.println(ans);
        }
    }
    
}
