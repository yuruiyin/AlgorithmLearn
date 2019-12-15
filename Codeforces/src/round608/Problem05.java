package round608;

import java.util.Scanner;

public class Problem05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            if (k == 1) {
                System.out.println(n);
                continue;
            }
            
            if (k == 2) {
                if (n % 2 == 1) {
                    System.out.println(n-1);
                } else {
                    System.out.println(n-2);
                }
                continue;
            }


        }
    }

}
