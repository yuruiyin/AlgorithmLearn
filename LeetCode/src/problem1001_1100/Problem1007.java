package problem1001_1100;

public class Problem1007 {

    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int ansMin = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            boolean isFound = true;
            int countA = 0;
            for (int j = 0; j < len; j++) {
                if (A[j] == i) {
                    continue;
                }

                if (B[j] != i) {
                    isFound = false;
                    break;
                }

                countA++;
            }

            if (!isFound) {
                continue;
            }

            int countB = 0;
            for (int j = 0; j < len; j++) {
                if (B[j] == i) {
                    continue;
                }

                if (A[j] != i) {
                    isFound = false;
                    break;
                }

                countB++;
            }

            if (!isFound) {
                ansMin = Math.min(ansMin, countA);
            } else {
                ansMin = Math.min(ansMin, Math.min(countA, countB));
            }
        }

        return ansMin == Integer.MAX_VALUE ? - 1: ansMin;
    }

}
