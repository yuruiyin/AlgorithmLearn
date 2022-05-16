package doubleContest.round78;

import java.util.*;

public class D_1 {

    public int largestVariance(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansMax = 0;
        int[][] preCountArr = new int[len][26];
        preCountArr[0][arr[0] - 'a'] = 1;
        List<Integer>[] indexListArr = new ArrayList[26];
        Arrays.setAll(indexListArr, value -> new ArrayList<>());
        indexListArr[arr[0] - 'a'].add(0);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                if ((arr[i] - 'a') == j) {
                    preCountArr[i][j] = preCountArr[i - 1][j] + 1;
                } else {
                    preCountArr[i][j] = preCountArr[i - 1][j];
                }
            }
            indexListArr[arr[i] - 'a'].add(i);
        }

        for (char min = 'a'; min <= 'z'; min++) {
            for (char max = 'a'; max <= 'z'; max++) {
                if (min == max || indexListArr[max - 'a'].isEmpty() || indexListArr[min - 'a'].isEmpty()) {
                    continue;
                }

                // 双指针
                List<Integer> maxIndexList = indexListArr[max - 'a'];
                int l = 0;
                int r = maxIndexList.size() - 1;
                while (l < r) {
                    int lIdx = maxIndexList.get(l);
                    int rIdx = maxIndexList.get(r);
                    int maxCharCount = preCountArr[rIdx][max - 'a'] - (lIdx == 0 ? 0 : preCountArr[lIdx - 1][max - 'a']);
                    int minCharCount = preCountArr[rIdx][min - 'a'] - (lIdx == 0 ? 0 : preCountArr[lIdx - 1][min - 'a']);
                    if (minCharCount == 0) {
                        ansMax = Math.max(ansMax, maxCharCount - 1);
                        break;
                    }

                    ansMax = Math.max(ansMax, maxCharCount - minCharCount);
                    int newRIdx = maxIndexList.get(r - 1);
                    int newMinCharCount1 = preCountArr[newRIdx][min - 'a'] - (lIdx == 0 ? 0 : preCountArr[lIdx - 1][min - 'a']);
                    int newLIdx = maxIndexList.get(l + 1);
                    int newMinCharCount2 = preCountArr[rIdx][min - 'a'] - (newLIdx == 0 ? 0 : preCountArr[newLIdx - 1][min - 'a']);
                    if (newMinCharCount1 == 0 && newMinCharCount2 == 0) {
                        ansMax = Math.max(ansMax, maxCharCount - 2);
                        break;
                    } else if (newMinCharCount1 == 0) {
                        ansMax = Math.max(ansMax, maxCharCount - 2);
                        l++;
                    } else if (newMinCharCount2 == 0) {
                        ansMax = Math.max(ansMax, maxCharCount - 2);
                        r--;
                    } else {
                        if (newMinCharCount1 <= newMinCharCount2) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
//        System.out.println(new D_1().largestVariance("aababbb"));
//        System.out.println(new D_1().largestVariance("lripaa"));
        System.out.println(new D_1().largestVariance("aaaaabbba"));
    }

}
