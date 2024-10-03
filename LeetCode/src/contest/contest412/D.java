package contest.contest412;

import java.util.*;

public class D {

    private int sortNum(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        Arrays.sort(numArr);
        return Integer.parseInt(new String(numArr));
    }

    private char[] getNumArr(int num) {
        return String.valueOf(num).toCharArray();
    }

    private char[] addPreZeros(char[] arr, int targetLen) {
        char[] newArr = new char[targetLen];
        Arrays.fill(newArr, '0');
        int diff = targetLen - arr.length;
        for (int i = targetLen - 1; i >= diff; i--) {
            newArr[i] = arr[i - diff];
        }
        return newArr;
    }

    private boolean isOk(char[] numArr1, char[] numArr2) {
        int diffCount = 0;
        for (int k = 0; k < numArr1.length; k++) {
            if (numArr1[k] != numArr2[k]) {
                diffCount++;
            }
        }
        return diffCount <= 4;
    }

    public int countPairs(int[] nums) {
        int len = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, char[]> arrMap = new HashMap<>();
        for (int num: nums) {
            int sort = sortNum(num);
            if (!map.containsKey(sort)) {
                map.put(sort, new ArrayList<>());
            }
            map.get(sort).add(num);

            if (!arrMap.containsKey(num)) {
                char[] arr = getNumArr(num);
                arrMap.put(num, arr);
            }
        }

        int ans = 0;
        for (int sort: map.keySet()) {
            List<Integer> numList = map.get(sort);
            int size = numList.size();
            if (sort < 100) {
                ans += (size * (size - 1)) / 2;
                continue;
            }
            for (int i = 0; i < size; i++) {
                char[] numArr1 = arrMap.get(numList.get(i));
                for (int j = i + 1; j < size; j++) {
                    // 比较二者之间数位不同的个数是否 <= 4
                    char[] numArr2 = arrMap.get(numList.get(j));
                    if (numArr1.length == numArr2.length) {
                        if (isOk(numArr1, numArr2)) {
                            ans++;
                        }
                    } else {
                        if (numArr1.length < numArr2.length) {
                            numArr1 = addPreZeros(numArr1, numArr2.length);
                            if (isOk(numArr1, numArr2)) {
                                ans++;

                            }
                        } else {
                            numArr2 = addPreZeros(numArr2, numArr1.length);
                            if (isOk(numArr1, numArr2)) {
                                ans++;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

}
