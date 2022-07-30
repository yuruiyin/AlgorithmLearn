package contest.contest299;

public class C {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] preSumArr1 = new int[len];
        int[] preSumArr2 = new int[len];
        preSumArr1[0] = nums1[0];
        for (int i = 1; i < len; i++) {
            preSumArr1[i] = preSumArr1[i - 1] + nums1[i];
        }
        preSumArr2[0] = nums2[0];
        for (int i = 1; i < len; i++) {
            preSumArr2[i] = preSumArr2[i - 1] + nums2[i];
        }

        int[] diffArr1 = new int[len];
        for (int i = 0; i < len; i++) {
            diffArr1[i] = preSumArr2[i] - preSumArr1[i];
        }
        int[] diffArr2 = new int[len];
        for (int i = 0; i < len; i++) {
            diffArr2[i] = preSumArr1[i] - preSumArr2[i];
        }
        int preMinDiff = 0;
        int ansMax = Math.max(preSumArr1[len - 1], preSumArr2[len - 1]);
        for (int i = 0; i < len; i++) {
            int diff = diffArr1[i];
            ansMax = Math.max(ansMax, preSumArr1[len - 1] + diff - preMinDiff);
            preMinDiff = Math.min(preMinDiff, diff);
        }
        preMinDiff = 0;
        for (int i = 0; i < len; i++) {
            int diff = diffArr2[i];
            ansMax = Math.max(ansMax, preSumArr2[len - 1] + diff - preMinDiff);
            preMinDiff = Math.min(preMinDiff, diff);
        }
        return ansMax;
    }

}
