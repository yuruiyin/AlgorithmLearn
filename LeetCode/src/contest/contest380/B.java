package contest.contest380;

import java.util.ArrayList;
import java.util.List;

public class B {

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
        List<Integer> aIdxList = new ArrayList<>();
        List<Integer> bIdxList = new ArrayList<>();
        char[] sArr = s.toCharArray();
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        for (int i = 0; i < sArr.length; ) {
            int idx = s.indexOf(a, i);
            if (idx != -1) {
                aIdxList.add(idx);
                i = idx + 1;
            } else {
                i++;
            }
        }

        for (int i = 0; i < sArr.length;) {
            int idx = s.indexOf(b, i);
            if (idx != -1) {
                bIdxList.add(idx);
                i = idx + 1;
            } else {
                i++;
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

    public static void main(String[] args) {
        // "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15
        System.out.println(new B().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
    }

}
