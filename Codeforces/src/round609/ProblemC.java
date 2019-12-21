package round609;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {
    
    private void print(int[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println();
    }

    private void addOne(int[] arr, int from, int to) {
        // 中间的数+1
        int carry = 1;
        for (int j = to; j >= from; j--) {
            if (carry == 0) {
                break;
            }

            int value = (arr[j] + carry) % 10;
            carry = (arr[j] + carry) / 10;
            arr[j] = value;
        }
    }

    private boolean isBigger(int[] arr1, int[] arr2) {
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            if (arr1[i] < arr2[i]) {
                return false;
            } else if (arr1[i] > arr2[i]) {
                return true;
            }
        }

        return true;
    }

    private void doAddOne(int n, int k, int[] arr, int[] b) {
        boolean isAllNine = true;
        for (int j = 1; j < k; j++) {
            if (arr[j] != 9) {
                isAllNine = false;
                break;
            }
        }

        // 前面太小，应该[1, k-1]之间加1
        if (k == 1 || isAllNine) {
            arr[0]++;
            for (int i = 0; i < n; i += k) {
                b[i] = arr[0];
            }
        } else {
            new ProblemC().addOne(arr, 1, k-1);
            for (int i = 0; i < n; i++) {
                b[i] = arr[i % k];
            }
        }

        System.out.println(n);
        new ProblemC().print(b);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            String num = scan.next();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = num.charAt(i) - '0';
            }

            int[] b = new int[n];

            if (arr[0] > arr[k]) {
                for (int i = 0; i < n; i++) {
                    b[i] = arr[i % k];
                }
                System.out.println(n);
                new ProblemC().print(b);
                continue;
            }

            if (arr[0] == arr[k]) {
                for (int i = 0; i < n; i++) {
                    b[i] = arr[i % k];
                }

                if (new ProblemC().isBigger(b, arr)) {
                    System.out.println(n);
                    new ProblemC().print(b);
                    continue;
                }

                Arrays.fill(b, 0);
            }

            new ProblemC().doAddOne(n, k, arr, b);
        }
    }
    
}
