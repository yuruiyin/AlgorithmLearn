package doubleContest.round32;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/8
 */
public class B {

    public boolean canConvertString(String s, String t, int k) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int len = arr1.length;

        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }

            int count = 0;
            if (arr2[i] > arr1[i]) {
                count = arr2[i] - arr1[i];
            } else {
                count = arr2[i] - arr1[i] + 26;
            }
            countList.add(count);
        }

        int diffSize = countList.size();
        if (diffSize > k) {
            return false;
        }

        int[] curMultipleArr = new int[26];

        Collections.sort(countList);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int count : countList) {
            countMap.put(count, countMap.getOrDefault(count, 0) + 1);
        }
//        TreeMultiSet<Integer> set = new TreeMultiSet<>(countList);

        for (int i = 0; i < diffSize; i++) {
            int count = countList.get(i);
            countMap.put(count, countMap.get(count) - 1);
            if (countMap.get(count) > 0) {
                boolean isOk = false;
                int mod = count % 26;
                int from = curMultipleArr[mod];
                int kk;
                for (kk = from + 1; count + 26 * kk <= k; kk++) {
                    if (countMap.getOrDefault(count + 26 * kk, 0) == 0) {
                        countList.set(i, count + 26 * kk);
                        countMap.put(count + 26 * kk, 1);
                        isOk = true;
                        break;
                    }
                }

                if (!isOk) {
                    return false;
                }

                curMultipleArr[mod] = kk;
            }
        }

        int maxCount = 0;
        for (int count : countList) {
            maxCount = Math.max(maxCount, count);
        }

        if (maxCount > k) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {
//        "bpmaaaljbfdp"
//        "djzbvyjrkkbs"
//        115
        System.out.println(new B().canConvertString("bpmaaaljbfdp", "djzbvyjrkkbs", 115));
    }

}
