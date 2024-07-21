package doubleContest.round135;

public class C {

    public int minChanges(int[] nums, int k) {
        int len = nums.length;
        int[] absCountArr = new int[k + 1];
        int l = 0;
        int r = len - 1;
        int[] sufCountArr = new int[k + 2];

        while (l < r) {
            absCountArr[Math.abs(nums[l] - nums[r])]++;
            int leftNum = nums[l];
            int rightNum = nums[r];
            int max = Math.max(Math.max(leftNum, rightNum), Math.max(k - leftNum, k - rightNum));
            sufCountArr[max + 1]++;
            l++;
            r--;
        }

        for (int i = 1; i <= k + 1; i++) {
            sufCountArr[i] += sufCountArr[i - 1];
        }

        int ansMin = Integer.MAX_VALUE;
        int mid = len / 2;
        for (int x = 0; x <= k; x++) {
            ansMin = Math.min(ansMin, mid - absCountArr[x] + sufCountArr[x]);
        }
        return ansMin;
    }

}
