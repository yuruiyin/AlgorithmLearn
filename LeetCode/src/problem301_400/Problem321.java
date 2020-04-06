package problem301_400;

import utils.PrintUtil;

import java.util.*;

/**
 * Problem321 TLE
 *
 * @author: yry
 * @date: 2020/3/24
 */
public class Problem321 {

    private int len1;
    private int len2;
    private int[][] suffixIndexArr1;
    private int[][] suffixIndexArr2;
    private Map<Integer, List<Integer>> memoMap;
    private List<Integer> nullList = new ArrayList<>();
    private List<Integer>[][] memo1;
    private List<Integer>[][] memo2;

    private List<Integer> dp1(int idx, int[][] suffixIndexArr, int k, List<Integer>[][] tmpMemo) {
        if (k == 0) {
            return new ArrayList<>();
        }

        if (suffixIndexArr.length - idx < k) {
            return nullList;
        }

        if (tmpMemo[idx][k] != null) {
            return tmpMemo[idx][k];
        }

        int[] suffixIndex = suffixIndexArr[idx];
        for (int i = 9; i >= 0; i--) {
            if (suffixIndex[i] == -1) {
                continue;
            }
            int nextIdx = suffixIndex[i] + 1;
            List<Integer> res;
            if ((res = dp1(nextIdx, suffixIndexArr, k - 1, tmpMemo)) != nullList) {
                List<Integer> ansList = new ArrayList<>();
                ansList.add(i);
                ansList.addAll(res);
                tmpMemo[idx][k] = ansList;
                return ansList;
            }
        }

        tmpMemo[idx][k] = nullList;
        return nullList;
    }

    private boolean isBigger(List<Integer> list1, List<Integer> list2) {
        int len = list1.size();
        for (int i = 0; i < len; i++) {
            if (list1.get(i) > list2.get(i)) {
                return true;
            } else if (list2.get(i) > list1.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> dp(int idx1, int idx2, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }

        if (len1 - idx1 + len2 - idx2 < k) {
            return null;
        }

        int key = k * len1 * len2 + idx1 * len2 + idx2;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (idx1 == len1) {
            List<Integer> res = dp1(idx2, suffixIndexArr2, k, memo2);
            memoMap.put(key, res);
            return res;
        }

        if (idx2 == len2) {
            List<Integer> res = dp1(idx1, suffixIndexArr1, k, memo1);
            memoMap.put(key, res);
            return res;
        }

        int[] suffixIndex1 = suffixIndexArr1[idx1];
        int[] suffixIndex2 = suffixIndexArr2[idx2];

        List<Integer> ansList1 = null;
        for (int i = 9; i >= 0; i--) {
            if (suffixIndex1[i] == -1) {
                continue;
            }

            int nextIdx1 = suffixIndex1[i] + 1;
            List<Integer> res = dp(nextIdx1, idx2, k - 1);
            if (res != null && res != nullList) {
                ansList1 = new ArrayList<>();
                ansList1.add(i);
                ansList1.addAll(res);
                break;
            }
        }

        List<Integer> ansList2 = null;
        for (int i = 9; i >= 0; i--) {
            if (suffixIndex2[i] == -1) {
                continue;
            }

            int nextIdx2 = suffixIndex2[i] + 1;
            List<Integer> res = dp(idx1, nextIdx2, k - 1);
            if (res != null && res != nullList) {
                ansList2 = new ArrayList<>();
                ansList2.add(i);
                ansList2.addAll(res);
                break;
            }
        }

        List<Integer> ansList = nullList;
        if (ansList1 != null && ansList2 != null) {
            if (isBigger(ansList1, ansList2)) {
                ansList = ansList1;
            } else {
                ansList = ansList2;
            }
        } else if (ansList1 != null) {
            ansList = ansList1;
        } else if (ansList2 != null) {
            ansList = ansList2;
        }

        memoMap.put(key, ansList);
        return ansList;
    }

    private void calcSuffixIndex(int[][] suffixIndexArr, int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            Arrays.fill(suffixIndexArr[i], -1);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= 9; j++) {
                if (j == arr[i]) {
                    suffixIndexArr[i][j] = i;
                } else {
                    if (i != len - 1) {
                        suffixIndexArr[i][j] = suffixIndexArr[i+1][j];
                    }
                }
            }
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        this.len1 = nums1.length;
        this.len2 = nums2.length;
        suffixIndexArr1 = new int[len1][10];
        suffixIndexArr2 = new int[len2][10];
        calcSuffixIndex(suffixIndexArr1, nums1);
        calcSuffixIndex(suffixIndexArr2, nums2);
        memoMap = new HashMap<>();
        memo1 = new ArrayList[len1 + 1][k + 1];
        memo2 = new ArrayList[len2 + 1][k + 1];
        List<Integer> ansList = dp(0, 0, k);
        return ansList.stream().mapToInt(Integer::intValue).toArray(); // list转int[]
    }

    public static void main(String[] args) {
        int[] ansArr = new Problem321().maxNumber(new int[]{
                8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5
        }, new int[]{
                7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3
        }, 500);
        PrintUtil.printIntArray(ansArr);
    }

}
