package problem1001_1100;

import java.util.*;

public class Problem1071_1 {

    private boolean isRepeat(String str, String compareStr, int len) {
        int strLen = str.length();
        if (strLen % len != 0) {
            return false;
        }

        int count = strLen / len;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < count; j++) {
                if (str.charAt(j * len + i) != compareStr.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<Integer> getAllCommonFactors(String str1, String str2) {
        int strLen1 = str1.length();
        int strLen2 = str2.length();
        List<Integer> commonFactors = new ArrayList<>();
        int end = (int) Math.sqrt(strLen1);
        for (int i = 1; i <= end; i++) {
            if (strLen1 % i == 0) {
                if (strLen2 % i == 0) {
                    commonFactors.add(i);
                }
                if (strLen2 % (strLen1 / i) == 0) {
                    commonFactors.add(strLen1 / i);
                }
            }
        }
        return commonFactors;
    }

    public String gcdOfStrings(String str1, String str2) {
        List<Integer> commonFactors = getAllCommonFactors(str1, str2);
        commonFactors.sort((o1, o2) -> o2 - o1);

        for (Integer factor : commonFactors) {
            if (isRepeat(str1, str2, factor) && isRepeat(str2, str2, factor)) {
                return str1.substring(0, factor);
            }
        }

        return "";
    }

}
