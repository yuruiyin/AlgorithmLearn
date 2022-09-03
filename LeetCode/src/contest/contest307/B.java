package contest.contest307;

import java.util.Arrays;

public class B {

    public String largestPalindromic(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        Arrays.sort(arr);
        int tmpLen = len;
        if (len % 2 == 0) {
            tmpLen++;
        }
        char[] ansArr = new char[tmpLen];
        Arrays.fill(ansArr, '.');
        int count = 0;
        int l = 0;
        for (int i = len - 1; i >= 0;) {
            if (i == 0) {
                if (count == 1) {
                    break;
                }
                if (ansArr[tmpLen / 2] == '.') {
                    ansArr[tmpLen / 2] = arr[i];
                }
                break;
            } else {
                if (arr[i] == arr[i - 1]) {
                    if (arr[i] > '0') {
                        ansArr[l] = arr[i];
                        ansArr[tmpLen - l - 1] = arr[i];
                        l++;
                        count += 2;
                        i -= 2;
                    } else {
                        if (count <= 1) {
                            if (count == 0) {
                                ansArr[tmpLen / 2] = '0';
                                count++;
                            }
                            break;
                        }
                        ansArr[l] = arr[i];
                        ansArr[tmpLen - l - 1] = arr[i];
                        l++;
                        count += 2;
                        i -= 2;
                    }
                } else {
                    if (ansArr[tmpLen / 2] == '.') {
                        ansArr[tmpLen / 2] = arr[i];
                    }
                    count++;
                    i--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmpLen; i++) {
            if (ansArr[i] != '.') {
                sb.append(ansArr[i]);
            }
        }
        return sb.toString();
    }

}
