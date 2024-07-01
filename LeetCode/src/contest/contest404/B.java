package contest.contest404;

public class B {

    public int maximumLength(int[] nums) {
        int len = nums.length;
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }
        }
        int evenCount = len - oddCount;

        // 奇偶奇偶奇偶
        boolean needOdd = true;
        int oddEvenCount = 0;
        for (int num : nums) {
            if (needOdd && num % 2 == 1) {
                oddEvenCount++;
                needOdd = false;
            } else if (!needOdd && num % 2 == 0) {
                oddEvenCount++;
                needOdd = true;
            }
        }

        needOdd = false;
        int evenOddCount = 0;
        for (int num : nums) {
            if (needOdd && num % 2 == 1) {
                evenOddCount++;
                needOdd = false;
            } else if (!needOdd && num % 2 == 0) {
                evenOddCount++;
                needOdd = true;
            }
        }

        return Math.max(Math.max(oddCount, evenCount), Math.max(oddEvenCount, evenOddCount));
    }

}
