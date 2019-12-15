package round608;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = scanner.next();
            List<Integer> ansList = new ArrayList<>();
            char[] arr = str.toCharArray();
            int len = arr.length;
            int bCount = 0;
            int wCount = 0;
            for (char c : arr) {
                if (c == 'B') {
                    bCount++;
                } else {
                    wCount++;
                }
            }

            if (bCount == 0 || wCount == 0) {
                System.out.println(0);
                continue;
            }

            if (len == 2 || bCount % 2 == 1 && wCount % 2 == 1) {
                System.out.println(-1);
                continue;
            }

            // 要变偶数的
            char finalChar = 'B';
            if (wCount % 2 == 1) {
                finalChar = 'W';
            }

            for (int i = len - 1; i >= 1; i--) {
                if (arr[i] != finalChar) {
                    if (arr[i-1] == 'B') {
                        arr[i-1] = 'W';
                    } else {
                        arr[i-1] = 'B';
                    }
                    ansList.add(i);
                }
            }
            
            System.out.println(ansList.size());
            for (Integer num: ansList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
