package fall_2022;

import java.util.Map;

public class A {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int len = temperatureA.length;
        int[] arr1 = new int[len - 1];
        int[] arr2 = new int[len - 1];
        for (int i = 1; i < len; i++) {
            if (temperatureA[i] > temperatureA[i - 1]) {
                arr1[i - 1] = -1;
            } else if (temperatureA[i] == temperatureA[i - 1]) {
                arr1[i - 1] = 0;
            } else {
                arr1[i - 1] = 1;
            }
            if (temperatureB[i] > temperatureB[i - 1]) {
                arr2[i - 1] = -1;
            } else if (temperatureB[i] == temperatureB[i - 1]) {
                arr2[i - 1] = 0;
            } else {
                arr2[i - 1] = 1;
            }
        }

        int max = arr1[0] == arr2[0] ? 1 : 0;
        int pre = max;
        for (int i = 1; i < len - 1; i++) {
            if (arr1[i] == arr2[i]) {
                pre++;
                max = Math.max(max, pre);
            } else {
                pre = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
