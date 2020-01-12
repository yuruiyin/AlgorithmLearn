package tencent2017_summer;

import java.util.Arrays;
import java.util.Scanner;

public class Problem03 {

    private static void handle() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] > max) {
                    max = arr[i];
                }

                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            
            if (n == 1) {
                System.out.println("0 0");
                continue;
            }

            Arrays.sort(arr);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n-1; i++) {
                int diff = arr[i+1] - arr[i];
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }

            int ansCount1 = 0, ansCount2 = 0;
            if (minDiff == 0) {
                // 有相等元素
                int tmpCount = 1;
                for (int i = 1; i < n; i++) {
                    if (arr[i] == arr[i-1]) {
                        tmpCount++;
                    } else {
                        if (tmpCount > 1) {
                            ansCount1 += tmpCount * (tmpCount - 1) / 2;
                        }
                        tmpCount = 1;
                    }
                }

                if (tmpCount > 1) {
                    ansCount1 += tmpCount * (tmpCount - 1) / 2;
                }
            } else {
                for (int i = 0; i < n-1; i++) {
                    int diff = arr[i+1] - arr[i];
                    if (diff == minDiff) {
                        ansCount1++;
                    }
                }
            }

            if (min == max) {
                ansCount2 = ansCount1;
            } else {

                int minNumCount = 0;
                int maxNumCount = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == min) {
                        minNumCount++;
                    }

                    if (arr[i] == max) {
                        maxNumCount++;
                    }
                }

                ansCount2 = minNumCount * maxNumCount;
            }
            
            System.out.println(ansCount1 + " " + ansCount2);

        }
    }

    public static void main(String[] args) {
        handle();
    }
    
}
