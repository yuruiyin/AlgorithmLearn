package contest.contest280;

/**
 * A
 *
 * @author: yry
 * @date: 2022/2/13
 */
public class B {

    public int minimumOperations(int[] nums) {
        int[] countArr1 = new int[100001];
        int[] countArr2 = new int[100001];
        int len = nums.length;
        int evenCount = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                countArr1[nums[i]]++;
                evenCount++;
            } else {
                countArr2[nums[i]]++;
            }
        }

        int oddCount = len - evenCount;

        int evenMax = 0;
        int evenMaxCount = 0;
        int evenSecondMax = 0;
        int evenSecondMaxCount = 0;

        int oddMax = 0;
        int oddMaxCount = 0;
        int oddSecondMax = 0;
        int oddSecondMaxCount = 0;
        for (int i = 1; i <= 100000; i++) {
            if (countArr1[i] > evenMaxCount) {
                evenMaxCount = countArr1[i];
                evenMax = i;
            }
        }

        for (int i = 1; i <= 100000; i++) {
            if (i != evenMax && countArr1[i] > evenSecondMaxCount) {
                evenSecondMaxCount = countArr1[i];
                evenSecondMax = i;
            }
        }

        for (int i = 1; i <= 100000; i++) {
            if (countArr2[i] > oddMaxCount) {
                oddMaxCount = countArr2[i];
                oddMax = i;
            }
        }

        for (int i = 1; i <= 100000; i++) {
            if (i != oddMax && countArr2[i] > oddSecondMaxCount) {
                oddSecondMaxCount = countArr2[i];
                oddSecondMax = i;
            }
        }

        if (evenMax != oddMax) {
            return evenCount - evenMaxCount + (oddCount - oddMaxCount);
        }

        return Math.min(evenCount - evenMaxCount + (oddCount - oddSecondMaxCount), evenCount - evenSecondMaxCount + (oddCount - oddMaxCount));


    }

}
