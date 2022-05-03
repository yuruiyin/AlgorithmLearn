package doubleContest.round76;

public class B {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; i * cost1 <= total; i++) {
            int left = total - cost1 * i;
            ans += left / cost2 + 1;
        }
        return ans;
    }

}
