package problem1001_1100;

public class Problem1010 {

    public int numPairsDivisibleBy60(int[] times) {
        int[] countArr = new int[60];

        for(int time: times) {
            countArr[time % 60]++;
        }

        int ans = 0;
        for (int i = 0; i < times.length; i++) {
            int time = times[i] % 60;
            countArr[time]--;
            int wantTime = (60 - time) % 60;
            ans += countArr[wantTime];
        }

        return ans;
    }

}
