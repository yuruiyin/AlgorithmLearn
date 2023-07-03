package spring_2023_group;

import java.util.Arrays;
import java.util.Map;

public class A {

    public int runeReserve(int[] runes) {
        Arrays.sort(runes);
        int ansMax = 1;
        int pre = 1;
        int len = runes.length;
        for (int i = 1; i < len; i++) {
            if (runes[i] <= runes[i - 1] + 1) {
                pre++;
                ansMax = Math.max(ansMax, pre);
            } else {
                pre = 1;
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
