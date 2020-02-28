package lcci;

public class Lcci0503 {

    private int getContinuousOneCount(long num) {
        int ansMax = 0;
        int count = 0;
        while (num > 0) {
            long bit = num & 1;
            if (bit == 1) {
                count++;
            } else {
                ansMax = Math.max(ansMax, count);
                count = 0;
            }

            num >>>= 1;
        }

        ansMax = Math.max(ansMax, count);
        return ansMax;
    }

    public int reverseBits(int num) {
        int ansMax = 0;
        for (int i = 0; i < 32; i++) {
            int bit = num & (1 << i);
            if (bit == 0) {
                int oneCount = getContinuousOneCount(num | (1L << i));
                ansMax = Math.max(ansMax, oneCount);
            }
        }

        return ansMax;
    }

}
