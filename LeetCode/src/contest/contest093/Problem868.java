package contest.contest093;

public class Problem868 {

    public int binaryGap(int n) {
        int max = 0;
        int index1 = -1;
        int index = 0;
        while (n > 0) {
            int bit = n & 1;
            if (bit == 1) {
                if (index1 == -1) {
                    index1 = index;
                } else {
                    max = Math.max(max, index - index1);
                    index1 = index;
                }
            }

            n >>>= 1;
            index++;
        }

        return max;
    }

}
