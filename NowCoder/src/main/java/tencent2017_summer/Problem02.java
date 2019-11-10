package tencent2017_summer;

import java.util.Scanner;

public class Problem02 {

    private static boolean isUppercase(char letter) {
        return letter >= 'A' && letter <= 'Z';
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void handle() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] arr = str.toCharArray();
            int len = arr.length;

            for (int i = len - 1; i >= 0; i--) {
                char c = arr[i];
                if (!isUppercase(c) || i == len - 1) {
                    continue;
                }

                int curIndex = i;
                for (int j = i + 1; j < len && !isUppercase(arr[j]); j++) {
                    swap(arr, curIndex, j);
                    curIndex = j;
                }
            }

            for (char c: arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        handle();
    }

}
