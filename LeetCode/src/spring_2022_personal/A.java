package spring_2022_personal;

import java.util.Arrays;

public class A {

    public int giveGem(int[] gem, int[][] operations) {
        int len = gem.length;
        for (int[] op : operations) {
            int fromIdx1 = op[0];
            int fromIdx2 = op[1];
            int count = gem[fromIdx1] / 2;
            gem[fromIdx1] -= count;
            gem[fromIdx2] += count;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (gem[i] > max) {
                max = gem[i];
            }
            if (gem[i] < min) {
                min = gem[i];
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
