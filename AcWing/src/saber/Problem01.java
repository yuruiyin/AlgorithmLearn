package saber;

import java.util.Scanner;

public class Problem01 {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String oper = scanner.next();
        double[][] grid = new double[12][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                grid[i][j] = scanner.nextDouble();
            }
        }

        double sum = 0;
        int count = 0;
        for (int i = 1; i < 12; i++) {
            for (int j = 12 - i; j < 12; j++) {
                sum += grid[i][j];
                count++;
            }
        }

        if (oper.equals("S")) {
            System.out.println(String.format("%.1f", sum));
        } else {
            System.out.println(String.format("%.1f", sum / count));
        }
    }

    public static void main(String[] args) {
        solve();
    }

}
