package contest.contest380;

import java.util.ArrayList;
import java.util.List;

public class D {

    class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

    }

    private int findFirstBiggerOrEqual(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target <= list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findLastSmallerOrEqual(List<Integer> list, int target) {
        int len = list.size();
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal <= target) {
                if (mid == len - 1 || list.get(mid + 1) > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        if (!s.contains(a) || !s.contains(b)) {
            return new ArrayList<>();
        }

        List<Integer> aIdxList = new ArrayList<>();
        List<Integer> bIdxList = new ArrayList<>();
        char[] sArr = s.toCharArray();
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        StrHash sHash = new StrHash(sArr);
        int idx = s.indexOf(a);
        long aHash = sHash.getSubStrHash(idx, idx + a.length() - 1);
        for (int i = 0; i < sArr.length - a.length() + 1; i++) {
            long hash = sHash.getSubStrHash(i, i + a.length() - 1);
            if (hash == aHash) {
                aIdxList.add(i);
            }
        }

        int idx1 = s.indexOf(b);
        long bHash = sHash.getSubStrHash(idx1, idx1 + b.length() - 1);
        for (int i = 0; i < sArr.length - b.length() + 1; i++) {
            long hash = sHash.getSubStrHash(i, i + b.length() - 1);
            if (hash == bHash) {
                bIdxList.add(i);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < aIdxList.size(); i++) {
            int left = Math.max(0, aIdxList.get(i) - k);
            int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(bIdxList, left);
            if (firstBiggerOrEqualIdx != -1 && bIdxList.get(firstBiggerOrEqualIdx) <= aIdxList.get(i)) {
                ansList.add(aIdxList.get(i));
            } else {
                int right = Math.min(sArr.length - 1, aIdxList.get(i) + k);
                int lastSmallerOrEqualIdx = findLastSmallerOrEqual(bIdxList, right);
                if (lastSmallerOrEqualIdx != -1 && bIdxList.get(lastSmallerOrEqualIdx) >= aIdxList.get(i)) {
                    ansList.add(aIdxList.get(i));
                }
            }
        }

        return ansList;
    }

}
