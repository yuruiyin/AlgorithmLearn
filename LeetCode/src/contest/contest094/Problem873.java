package contest.contest094;

import java.util.HashSet;
import java.util.Set;

public class Problem873 {

    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(arr[i]);
        }

        int firstNum = -1;
        int secondNum = -1;
        int max = 0;
        for (int i = 0; i < len; i++) {
            int oldFirstNum = arr[i];
            for (int j = i + 1; j < len; j++) {
                firstNum = oldFirstNum;
                secondNum = arr[j];
                int thirdNum = firstNum + secondNum;
                int count = 2;
                while (set.contains(thirdNum)) {
                    count++;
                    firstNum = secondNum;
                    secondNum = thirdNum;
                    thirdNum = firstNum + secondNum;
                }

                max = Math.max(max, count);
            }
        }

        return max <= 2 ? 0 : max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem873().lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
    }

}
