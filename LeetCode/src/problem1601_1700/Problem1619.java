package problem1601_1700;

import java.util.Arrays;

public class Problem1619 {

    public double trimMean(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        double sum = 0;
        int s = (int) (len * 0.05);
        int e = (int) (len - len * 0.05);
        for (int i = s; i < e; i++) {
            sum += arr[i];
        }
        return sum / (e - s);
    }

}
