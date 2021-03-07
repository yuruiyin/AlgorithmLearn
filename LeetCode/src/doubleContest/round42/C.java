package doubleContest.round42;

import java.util.LinkedList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/26
 */
public class C {

    public String maximumBinaryString(String binary) {
        char[] arr = binary.toCharArray();
        int len = arr.length;
        LinkedList<Integer> zeroIdxList = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (arr[i] == '0') {
                zeroIdxList.addLast(i);
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == '1') {
                continue;
            }

            if (arr[i + 1] == '0') {
                arr[i] = '1';
            } else {
                int oneCount = 0;
                for (int j = i + 1; j < len; j++) {
                    if (arr[j] == '1') {
                        oneCount++;
                    }
                }

                int leftCount = len - i - 1;
                int leftOneCount = leftCount - oneCount;
                if (leftOneCount == 0) {
                    break;
                }

                for (int j = i; j < i + leftOneCount; j++) {
                    arr[j] = '1';
                }

                arr[i + leftOneCount] = '0';
                for (int j = i + leftOneCount + 1; j < len; j++) {
                    arr[j] = '1';
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }

}
