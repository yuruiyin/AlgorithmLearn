package contest.contest222;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/3
 */
public class C {

    private static final int MOD = 1000000007;

    public int waysToSplit(int[] nums) {
        int len = nums.length;
        int[] preSumArr = new int[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        int sum = preSumArr[len - 1];
        int ansCount = 0;
        for (int i = 0; i < len - 2; i++) {
            if (preSumArr[i] > sum / 3) {
                break;
            }

            int l = i + 1;
            int r = len - 2;
            int lTarget = -1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (preSumArr[mid] - preSumArr[i] < preSumArr[i]) {
                    l = mid + 1;
                } else {
                    if (mid == i + 1 || preSumArr[mid - 1] - preSumArr[i] < preSumArr[i]) {
                        lTarget = mid;
                        break;
                    }
                    r = mid - 1;
                }
            }

            if (lTarget == -1) {
                continue;
            }


            l = lTarget + 1;
            r = len - 1;
            int rTarget = -1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (sum - preSumArr[mid - 1] < preSumArr[mid - 1] - preSumArr[i]) {
                    r = mid - 1;
                } else {
                    if (mid == len - 1 || sum - preSumArr[mid] < preSumArr[mid] - preSumArr[i]) {
                        rTarget = mid;
                        break;
                    }
                    l = mid + 1;
                }
            }

            if (rTarget == -1 || rTarget <= lTarget) {
                continue;
            }

            ansCount = (ansCount +  (rTarget - lTarget)) % MOD;
        }

        return ansCount;
    }

    public static void main(String[] args) {
        System.out.println(new C().waysToSplit(new int[]{2, 3, 5, 10}));
    }

}
