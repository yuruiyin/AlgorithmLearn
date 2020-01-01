package problem801_900;

import java.util.ArrayList;
import java.util.List;

public class Problem866 {

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int find(List<Integer> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal < target) {
                if (list.get(mid + 1) >= target) {
                    return mid + 1;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    public int primePalindrome(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }

        int numBit = String.valueOf(n).length() + 2;
        for (int i = 2; i <= numBit; i++) {
            int leftBitCount = i / 2;
            int max = (int) (Math.pow(10, leftBitCount) - 1);
            int min = (int) Math.pow(10, leftBitCount - 1);

            for (int j = min; j <= max; j++) {
                String leftNumStr = String.valueOf(j);
                if (j >= 2000) {
                    break;
                }

                if (i % 2 == 0) {
                    String numStr = leftNumStr + new StringBuilder(leftNumStr).reverse().toString();
                    list.add(Integer.parseInt(numStr));
                } else {
                    for (int k = 0; k <= 9; k++) {
                        String numStr = leftNumStr + k + new StringBuilder(leftNumStr).reverse().toString();
                        list.add(Integer.parseInt(numStr));
                    }
                }
            }
        }

        int from = find(list, n);
        int size = list.size();

        for (int i = from; i < size; i++) {
            int num = list.get(i);
            if (isPrime(num)) {
                return num;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Problem866().primePalindrome(0));
    }
}
