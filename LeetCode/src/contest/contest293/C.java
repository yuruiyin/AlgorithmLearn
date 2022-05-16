package contest.contest293;

public class C {

    public int largestCombination(int[] arr) {
        int[] countArr = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32 && num > 0; i++) {
                countArr[i] += ((num >> i) & 1);
            }
        }

        int ansMax = 0;
        for (int i = 0; i < 32; i++) {
            ansMax = Math.max(ansMax, countArr[i]);
        }
        return ansMax;
    }

}
