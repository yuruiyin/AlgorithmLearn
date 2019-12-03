package lcp;

public class Problem01 {

    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                ans++;
            }
        }

        return ans;
    }

}
