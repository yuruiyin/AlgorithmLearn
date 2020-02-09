package problem901_1000;

public class Problem961 {

    public int repeatedNTimes(int[] arr) {
        int[] countArr = new int[10001];
        for (int num : arr) {
            countArr[num]++;
        }

        for (int i = 0; i < 10001; i++) {
            if (countArr[i] > 1) {
                return i;
            }
        }

        return -1;
    }

}
