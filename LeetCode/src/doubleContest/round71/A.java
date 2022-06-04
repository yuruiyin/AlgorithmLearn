package doubleContest.round71;

import java.util.Arrays;

public class A {

    public int minimumSum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        int val1 = (arr[0] - '0') * 10 + (arr[2] - '0');
        int val2 = (arr[1] - '0') * 10 + (arr[3] - '0');
        return val1 + val2;
    }

}
