package contest.contest402;

public class B {

    public long countCompleteDayPairs(int[] hours) {
        int len = hours.length;
        long ans = 0;
        int[] countArr = new int[24];
        countArr[hours[0] % 24] = 1;
        for (int i = 1; i < len; i++) {
            int right = hours[i] % 24;
            int left = (24 - right) % 24;
            ans += countArr[left];
            countArr[right]++;
        }
        return ans;
    }

}
