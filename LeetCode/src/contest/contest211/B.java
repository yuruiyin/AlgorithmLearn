package contest.contest211;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/18
 */
public class B {

    public String findLexSmallestString(String s, int a, int b) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] oldArr = Arrays.copyOf(arr, arr.length);

        if (b % 2 == 0) {
            // b是偶数
            char[] totalAnsArr = new char[len];
            Arrays.fill(totalAnsArr, '9');

            for (int k = 0; ; k++) {
                arr = oldArr;
                for (int i = 1; i < len; i += 2) {
                    arr[i] = (char) ((arr[i] - '0' + a * k) % 10 + '0');
                }
                char[] ansArr = new char[len];
                Arrays.fill(ansArr, '9');

                for (int i = 0; i < len; i += 2) {
                    int from = i;
                    int count = 0;
                    char[] tmpArr = new char[len];
                    for (int j = from; count < len; j = (j + 1) % len) {
                        tmpArr[count++] = arr[j];
                    }

                    if (Arrays.compare(tmpArr, ansArr) < 0) {
                        ansArr = tmpArr;
                    }
                }

                if (Arrays.compare(totalAnsArr, ansArr) == 0) {
                    break;
                }

                if (Arrays.compare(ansArr, totalAnsArr) < 0) {
                    totalAnsArr = ansArr;
                }
            }

            return new String(totalAnsArr);
        } else {
            // b是奇数
            char[] ansArr = Arrays.copyOf(arr, len);
            int time = 0;

            for (int i = 0; time < 2 * len ; i = (i + 1) % len) {
                int from = i;
                int count = 0;
                char[] lastArr = Arrays.copyOf(ansArr, len);
                char[] tmpArr = Arrays.copyOf(oldArr, len);
                for (int j = from; count < len; j = (j + 1) % len) {
                    tmpArr[count++] = lastArr[j];
                }

                for (int k = 0; k <= 10; k++) {
                    for (int j = 1; j < len; j += 2) {
                        tmpArr[j] = (char) ((tmpArr[j] - '0' + a * k) % 10 + '0');
                    }

                    if (Arrays.compare(tmpArr, ansArr) < 0) {
                        ansArr = Arrays.copyOf(tmpArr, len);
                    }
                }
                time++;
            }

            return new String(ansArr);
        }
    }

    public static void main(String[] args) {
        System.out.println(new B().findLexSmallestString("74", 5, 1));
        System.out.println(new B().findLexSmallestString("43987654", 7, 3));
    }
}
