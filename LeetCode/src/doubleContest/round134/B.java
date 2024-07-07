package doubleContest.round134;

import java.util.Arrays;

public class B {

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        long newCurrentEnergy = currentEnergy;
        if (newCurrentEnergy < enemyEnergies[0]) {
            return 0;
        }

        int len = enemyEnergies.length;
        long ans = 1;
        newCurrentEnergy -= enemyEnergies[0];
        for (int i = 1; i < len; i++) {
            newCurrentEnergy += enemyEnergies[i];
        }

        return ans + newCurrentEnergy / enemyEnergies[0];
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
