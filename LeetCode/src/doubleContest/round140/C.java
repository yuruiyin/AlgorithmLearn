package doubleContest.round140;

import java.util.*;

public class C {

    private List<Integer>[] getIndexListArr(char[] arr) {
        List<Integer>[] indexListArr = new ArrayList[26];
        Arrays.setAll(indexListArr, value -> new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            indexListArr[arr[i] - 'a'].add(i);
        }
        return indexListArr;
    }

    public int[] validSequence(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] ansArr = new int[len2];

//        List<Integer>[] indexListArr1 = getIndexListArr(arr1);
//        List<Integer>[] indexListArr2 = getIndexListArr(arr2);

        int i = 0;
        int j = 0;

        boolean hasChange = true;
        Set<Long> memoSet = new HashSet<>();

        while (j < len2) {
            if (len1 - i < len2 - j) {
                return new int[0];
            }
            if (arr1[i] == arr2[j]) {
                ansArr[j] = i;
                i++;
                j++;
            } else {
                if (hasChange) {
                    // 有机会的情况下，可以用，也可以不用
                    // 用掉
                    int oldI = i;
                    int oldJ = j;
                    ansArr[j] = i;
                    i++;
                    j++;
                    hasChange = false;
                    boolean isOk = true;
                    while (j < len2) {
                        long key = i * (long)3e5 + j;
                        if (memoSet.contains(key)) {
                            isOk = false;
                            break;
                        }
                        memoSet.add(key);
                        if (len1 - i < len2 - j) {
                            isOk = false;
                            break;
                        }
                        if (arr1[i] == arr2[j]) {
                            ansArr[j] = i;
                            i++;
                            j++;
                        } else {
                            i++;
                        }
                    }

                    if (isOk) {
                        return ansArr;
                    }

                    // 不能用掉
                    i = oldI + 1;
                    j = oldJ;
                    hasChange = true;
                } else {
                    i++;
                }
            }
        }

        return ansArr;
    }

}
