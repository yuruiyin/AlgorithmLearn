package lcof;

import java.util.ArrayList;
import java.util.List;

public class Lcof057_2_1 {

//    private boolean isPerfectSquareNum(long num) {
//        long low = 0;
//        long high = num;
//        while (low <= high) {
//            long mid = (low + high) >>> 1;
//            long square = mid * mid;
//            if (square == num) {
//                return true;
//            } else if (square < num) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return false;
//    }

    private boolean isPerfectSquareNum(long num) {
        long sqrt = (long) Math.sqrt(num);
        return  sqrt * sqrt == num;
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> ansList = new ArrayList<>();
        int end = target / 2;
        for (int a = 1; a <= end; a++) {
            long delta = (2 * a - 1L) * (2 * a - 1L) + 8 * target;
            if (!isPerfectSquareNum(delta)) {
                continue;
            }

            int top = (int) (Math.sqrt(delta) - 2 * a + 1);
            if (top % 2 == 0) {
                int n = top / 2;
                int[] arr = new int[n];
                arr[0] = a;
                for (int i = 1; i < n; i++) {
                    arr[i] = arr[i-1] + 1;
                }
                ansList.add(arr);
            }
        }

        int size = ansList.size();
        int[][] ansArr = new int[size][];

        for (int i = 0; i < size; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

}
