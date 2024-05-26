package contest.contest391;

public class B {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int ans = 0;
        while (true) {
            if (numBottles > 0) {
                ans += numBottles;
                emptyBottles += numBottles;
                numBottles = 0;
            } else {
                if (emptyBottles >= numExchange) {
                    emptyBottles -= numExchange;
                    numBottles++;
                    numExchange++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

}
