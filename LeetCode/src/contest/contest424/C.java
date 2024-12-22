package contest.contest424;

public class C {

    // 差分
    public int[] getModifiedArray(int length, int[][] updates, int k) {
        int[] diff = new int[length];
        for (int i = 0; i < k; i++) {
            int[] update = updates[i];
            int startIdx = update[0];
            int endIdx = update[1];
            int inc = -update[2];
            diff[startIdx] += inc;
            if (endIdx < length - 1) {
                diff[endIdx + 1] -= inc;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i-1];
        }

        return diff;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int len = nums.length;
        int qLen = queries.length;
        int l = 0;
        int r = qLen;
        int ansK = -1;
        while (l <= r) {
            int k = (l + r) >>> 1;
            int[] diff = getModifiedArray(len, queries, k);
            boolean isOk = true;
            for (int i = 0; i < len; i++) {
                if (nums[i] + diff[i] > 0) {
                   isOk = false;
                   break;
                }
            }
            if (isOk) {
                ansK = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return ansK;
    }

    public static void main(String[] args) {

    }

}
