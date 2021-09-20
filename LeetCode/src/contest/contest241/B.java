package contest.contest241;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/16
 */
public class B {

    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;

        int oneCount = 0;
        for (char c : arr) {
            if (c == '1') {
                oneCount++;
            }
        }

        if (len % 2 == 0) {
            if (oneCount != len / 2) {
                return -1;
            }
        } else {
            if (oneCount != len / 2 && oneCount != len / 2 + 1) {
                return -1;
            }
        }

        char[] arr1 = new char[len];
        arr1[0] = '0';
        for (int i = 1; i < len; i++) {
            arr1[i] = arr1[i - 1] == '0' ? '1' : '0';
        }

        char[] arr2 = new char[len];
        arr2[0] = '1';
        for (int i = 1; i < len; i++) {
            arr2[i] = arr2[i - 1] == '0' ? '1' : '0';
        }

        int diffCount1 = 0;
        for (int i = 0; i < len; i++) {
            if (arr1[i] != arr[i]) {
                diffCount1++;
            }
        }

        if (diffCount1 == len) {
            return 0;
        }

        int diffCount2 = 0;
        for (int i = 0; i < len; i++) {
            if (arr2[i] != arr[i]) {
                diffCount2++;
            }
        }

        if (diffCount2 == len) {
            return 0;
        }

        if (len % 2 == 1) {
            if (oneCount == len / 2) {
                // 1比较少
                return diffCount1 / 2;
            }

            return  diffCount2 / 2;
        } else {
            return Math.min(diffCount1 / 2, diffCount2 / 2);
        }

    }

}
