package doubleContest.round141;

public class C {

    private boolean[] canRemoveArr;

    private int sLen;

    private int pLen;

    private Integer[][] memo;

    private int[] rightMaxRemoveCountArr;

    private int rec(int sIdx, int pIdx, char[] source, char[] pattern) {
        if (sLen - sIdx < pLen - pIdx) {
            return -1;
        }

        if (pIdx == pLen) {
            return rightMaxRemoveCountArr[sIdx];
        }

        if (memo[sIdx][pIdx] != null) {
            return memo[sIdx][pIdx];
        }

        // 删 or 不删
        int res;
        if (canRemoveArr[sIdx]) {
            // 可以删
            if (source[sIdx] != pattern[pIdx]) {
                // 不相等的情况删了更好
                int tmpRes = rec(sIdx + 1, pIdx, source, pattern);
                res = tmpRes == -1 ? -1 : tmpRes + 1;
            } else {
                // 相等的情况可以选择删也可以不删
                int tmpRes = rec(sIdx + 1, pIdx, source, pattern);
                int removeRes = tmpRes == -1 ? -1 : tmpRes + 1;
                int nonRemoveRes = rec(sIdx + 1, pIdx + 1, source, pattern);
                res = Math.max(removeRes, nonRemoveRes);
            }
        } else {
            // 不能删
            if (source[sIdx] == pattern[pIdx]) {
                res = rec(sIdx + 1, pIdx + 1, source, pattern);
            } else {
                res = rec(sIdx + 1, pIdx, source, pattern);
            }
        }

        return memo[sIdx][pIdx] = res;
    }

    private void calcRightMaxRemoveCountArr() {
        rightMaxRemoveCountArr = new int[sLen + 1];
        rightMaxRemoveCountArr[sLen - 1] = canRemoveArr[sLen - 1] ? 1 : 0;
        for (int i = sLen - 2; i >= 0; i--) {
            if (canRemoveArr[i]) {
                rightMaxRemoveCountArr[i] = rightMaxRemoveCountArr[i + 1] + 1;
            } else {
                rightMaxRemoveCountArr[i] = rightMaxRemoveCountArr[i + 1];
            }
        }
    }

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        this.sLen = source.length();
        this.pLen = pattern.length();
        canRemoveArr = new boolean[sLen];
        for (int idx: targetIndices) {
            canRemoveArr[idx] = true;
        }

        calcRightMaxRemoveCountArr();

        memo = new Integer[sLen][pLen];
        return rec(0, 0, source.toCharArray(), pattern.toCharArray());
    }

}
