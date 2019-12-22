package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1291 {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9-i+1; j++) {
                int num = j;
                for (int k = 1; k < i; k++) {
                    num *= 10;
                    num += (j + k);
                }
                list.add(num);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (Integer num : list) {
            if (num >= low && num <= high) {
                ansList.add(num);
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1291().sequentialDigits(10, 10000));
    }
    
}
