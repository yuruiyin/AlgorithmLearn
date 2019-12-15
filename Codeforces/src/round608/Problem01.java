package round608;

import java.util.Scanner;

public class Problem01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            int e = scan.nextInt();
            int f = scan.nextInt();

            int ansCost = 0;
            if (e >= f) {
                int min = Math.min(a, d);
                ansCost = e * min;
                d -= min;
                ansCost += f * Math.min(Math.min(b, c), d);
            } else {
                int min = Math.min(Math.min(b, c), d);
                ansCost = f * min;
                d -= min;
                ansCost += e * Math.min(a, d);
            }

            System.out.println(ansCost);
        }

    }

}
