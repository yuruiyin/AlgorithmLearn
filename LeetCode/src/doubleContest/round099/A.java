package doubleContest.round099;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A {

    public int splitNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        Arrays.sort(arr);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < len;) {
            if (arr[i] == '0') {
                i++;
                continue;
            }
            num1 *= 10;
            num1 += arr[i] - '0';
            if (i < len - 1) {
                num2 *= 10;
                num2 += arr[i + 1] - '0';
            }
            i += 2;
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(new A().splitNum(10));
    }

}
