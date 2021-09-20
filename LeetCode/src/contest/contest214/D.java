package contest.contest214;

import utils.SegmentTree;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int createSortedArray(int[] arr) {
        long ans = 0;
        int len = arr.length;
        SegmentTree segmentTree = new SegmentTree(1, 100000);

        for (int i = 0; i < len; i++) {
            int smallerCount = segmentTree.findSmallerCount(arr[i]);
            int biggerCount = segmentTree.findBiggerCount(arr[i]);
            ans = (ans + Math.min(smallerCount, biggerCount)) % MOD;
            segmentTree.insert(arr[i]);
        }

        return (int) ans % MOD;
    }

}
