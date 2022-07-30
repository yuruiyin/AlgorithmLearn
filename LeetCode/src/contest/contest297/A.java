package contest.contest297;

import java.util.Map;

public class A {

    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for (int i = 0; i < brackets.length; i++) {
            int[] bra = brackets[i];
            int u = bra[0];
            int p = bra[1];
            if (i == 0) {
                int value = Math.min(income, u);
                income -= value;
                ans += value * p / 100.0;
            } else {
                int value = Math.min(income, brackets[i][0] - brackets[i - 1][0]);
                income -= value;
                ans += value * p / 100.0;
            }
            if (income <= 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
