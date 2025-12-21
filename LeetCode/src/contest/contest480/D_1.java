package contest.contest480;

import java.util.ArrayList;
import java.util.List;

public class D_1 {

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

    public int[] minDeletions(String s, int[][] queries) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        List<Integer> idxList = new ArrayList<>();
        idxList.add(0);
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            idxList.add(i);
        }

        List<Integer> ansList = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                // 修改
                int j = q[1];
                if (j == 0) {
                    if (len > 1) {
                        if (arr[j] == arr[j + 1]) {
                            idxList.add(1, 1);
                        } else {
                            idxList.remove(1);
                        }
                    }
                } else {
                    int firstBiggerIdx = findLastSmallerOrEqual(idxList, j);
                    if (arr[j] == arr[j - 1]) {
                        // 新增一个
                        idxList.add(firstBiggerIdx + 1, j);
                        if (j < len - 1) {
                            if (arr[j] == arr[j + 1]) {
                                idxList.add(firstBiggerIdx + 2, j + 1);
                            } else {
                                idxList.remove(firstBiggerIdx + 2);
                            }
                        }
                    } else {
                        idxList.remove(firstBiggerIdx);
                        if (j < len - 1) {
                            if (arr[j] == arr[j + 1]) {
                                idxList.add(firstBiggerIdx, j + 1);
                            } else {
                                idxList.remove(firstBiggerIdx);
                            }
                        }
                    }
                }
                if (arr[j] == 'A') {
                    arr[j] = 'B';
                } else {
                    arr[j] = 'A';
                }
            } else {
                int l = q[1];
                int r = q[2];
                if (l == r) {
                    ansList.add(0);
                    continue;
                }

                int leftFirstBiggerOrEqualIdx = findLastSmallerOrEqual(idxList, l);
                int rightFirstBiggerOrEqualIdx = findLastSmallerOrEqual(idxList, r);
                if (leftFirstBiggerOrEqualIdx == rightFirstBiggerOrEqualIdx) {
                    ansList.add(r - l);
                    continue;
                }

                int res = idxList.get(rightFirstBiggerOrEqualIdx) - idxList.get(leftFirstBiggerOrEqualIdx + 1)
                        - (rightFirstBiggerOrEqualIdx - leftFirstBiggerOrEqualIdx)
                        + (idxList.get(leftFirstBiggerOrEqualIdx + 1) - l)
                        + (r - idxList.get(rightFirstBiggerOrEqualIdx));
                ansList.add(res);
            }
        }

        int[] ansArr = new int[ansList.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println(new D_1().minDeletions("ABA", new int[][]{{2,1,2}, {1,1}, {2,0,2}}));
    }

}
