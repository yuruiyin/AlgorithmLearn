package interview_2020;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class C {

    private boolean isSuffixAllZero(char[] arr, int from) {
        for (int i = from; i < arr.length; i++) {
            if (arr[i] != '.' && arr[i] != '0') {
                return false;
            }
        }
        return true;
    }

    public int compareVersion(String version1, String version2) {
        char[] arr1 = version1.toCharArray();
        char[] arr2 = version2.toCharArray();
        int len1 = version1.length();
        int len2 = version2.length();
        int first = 0;
        int second = 0;
        while (first < len1 && second < len2) {
            StringBuilder firstSb = new StringBuilder();
            while (first < len1 && arr1[first] != '.') {
                firstSb.append(arr1[first]);
                first++;
            }

            StringBuilder secondSb = new StringBuilder();
            while (second < len2 && arr2[second] != '.') {
                secondSb.append(arr2[second]);
                second++;
            }

            first++;
            second++;

            int subVersion1 = Integer.parseInt(firstSb.toString());
            int subVersion2 = Integer.parseInt(secondSb.toString());
            if (subVersion1 < subVersion2) {
                return -1;
            } else if (subVersion1 > subVersion2) {
                return 1;
            }
        }

        if (first < len1) {
            // 判断version1后面是不是都是0
            if (isSuffixAllZero(arr1, first)) {
                return 0;
            }
            return 1;
        } else if (second < len2) {
            // 判断version2后面是不是都是0
            if (isSuffixAllZero(arr2, second)) {
                return 0;
            }
            return -1;
        }

        return 0;
    }

}
