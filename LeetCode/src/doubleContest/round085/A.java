package doubleContest.round085;

import java.util.Map;

public class A {

    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int len = arr.length;
        int ansMin = len;
        for (int i = 0; i + k <= len; i++) {
            int count = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] == 'W') {
                    count++;
                }
            }
            ansMin = Math.min(ansMin, count);
        }
        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println("hell");
    }

}
