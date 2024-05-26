package contest.contest364;

import java.util.Arrays;

public class A {

    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int oneCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                oneCount++;
            }
        }

        for (int i = 0; i < oneCount - 1; i++) {
            sb.append('1');
        }

        int zeroCount = arr.length - oneCount;
        for (int i = 0; i < zeroCount; i++) {
            sb.append('0');
        }

        sb.append('1');

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
