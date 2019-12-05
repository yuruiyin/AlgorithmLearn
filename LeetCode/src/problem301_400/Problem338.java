package problem301_400;

public class Problem338 {

    public int[] countBits(int num) {
        int[] ansArr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ansArr[i] = Integer.bitCount(i);
        }

        return ansArr;
    }

}
