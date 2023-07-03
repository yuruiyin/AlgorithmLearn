package contest.contest338;

import java.util.ArrayList;
import java.util.List;

public class B {

    private static List<Integer> primeList;

    private static boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> getPrimeList() {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                ansList.add(i);
            }
        }
        return ansList;
    }

    public boolean primeSubOperation(int[] nums) {
        if (primeList == null) {
            primeList = getPrimeList();
        }

        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                int targetNum = -1;
                for (int prime: primeList) {
                    if (prime >= nums[i]) {
                        break;
                    }
                    if (nums[i] - prime < nums[i + 1]) {
                        targetNum = nums[i] - prime;
                        break;
                    }
                }
                if (targetNum == -1) {
                    return false;
                }
                nums[i] = targetNum;
            }
        }

        return true;
    }

}
