package doubleContest.round094;

import java.util.Map;

public class A {

    public int captureForts(int[] forts) {
        int len = forts.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            if (forts[i] == 1) {
                int count = 0;
                boolean isFound = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (forts[j] == 1) {
                        break;
                    }
                    if (forts[j] == -1) {
                        isFound = true;
                        break;
                    } else {
                        count++;
                    }
                }
                if (isFound) {
                    ansMax = Math.max(ansMax, count);
                }

                count = 0;
                isFound = false;
                for (int j = i + 1; j < len; j++) {
                    if (forts[j] == 1) {
                        break;
                    }
                    if (forts[j] == -1) {
                        isFound = true;
                        break;
                    } else {
                        count++;
                    }
                }
                if (isFound) {
                    ansMax = Math.max(ansMax, count);
                }
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
