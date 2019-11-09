package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1089 {

    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (num == 0) {
                list.add(0);
                list.add(0);
            } else {
                list.add(num);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    
    public static void main(String[] args) {

    }
    
}
