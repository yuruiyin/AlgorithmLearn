package doubleContest.round087;

import java.util.Arrays;

public class B {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        for (int i = 0, j = 0; i < players.length && j < trainers.length;) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }

}
