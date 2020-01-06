package contest.contest101;

import java.util.HashSet;
import java.util.Set;

public class Problem902 {

    private int[] countArr;
    private int len;
    private Set<Integer> numSet;
    private int[] numArr;

    private int recursive(int n) {
        if (n < 10) {
            int j;
            for (j = 0; j < len; j++) {
                if (numArr[j] > n) {
                    return j;
                }
            }

            return j;
        }
        int sum = 0;
        int i;
        int tmpN = n;
        for (i = 1; tmpN >= 10 ; i++) {
            sum += countArr[i];
            tmpN /= 10;
        }

        // 如n=325，前面已经求得100以内的个数，现在要求[100, 325]的个数
        int highBit = (int) (n / Math.pow(10, i-1));
        int rightBitCount = i - 1;
        for (int j = 0; j < len; j++) {
            if (numArr[j] < highBit) {
                sum += countArr[rightBitCount];
            }
        }

        if (!numSet.contains(highBit)) {
            return sum;
        }

        int rightNum = (int) (n % Math.pow(10, i-1));
        if (String.valueOf(rightNum).length() < i-1) {
            return sum;
        }
        // 判断小于rightNum （如325剩下25,看看有多少组合是<= 25）

        if (rightNum < 10) {
            return sum + recursive(rightNum);
        }

        return sum + recursive(rightNum) - recursive((int) Math.pow(10, i-2));
    }

    public int atMostNGivenDigitSet(String[] arr, int n) {
        countArr = new int[10];
        this.len = arr.length;
        for (int i = 1; i <= 9; i++) {
            countArr[i] = (int) Math.pow(len, i);
        }

        numArr = new int[len];
        numSet = new HashSet<>();
        for (int j = 0; j < len; j++) {
            numArr[j] = Integer.parseInt(arr[j]);
            numSet.add(numArr[j]);
        }

        return recursive(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"1","5","7","8"}, 10212)); // 340
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"1","2","3","6", "7", "8"}, 211)); //79
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"3","4","5","6"}, 64)); // 18
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100)); // 20
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));  // 29523
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"7"}, 78)); // 2
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"7"}, 8));  // 1
        System.out.println(new Problem902().atMostNGivenDigitSet(new String[]{"1","2","3","4","5","6","7","8","9"}, 1000000000)); // 435848049
    }

}
