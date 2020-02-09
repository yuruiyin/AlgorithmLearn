package doubleContest.round19;

public class Problem01 {

    public int numberOfSteps (int num) {
        int ans = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            ans++;
        }

        return ans;
    }

}
