package problem101_200;

public class Problem134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for (int i = 0; i < len; i++) {
            int gasSum = 0;
            for (int j = i; ;j = (j+1) % len) {
                gasSum += gas[j];
                gasSum -= cost[j];
                if (gasSum < 0) {
                    break;
                }

                if ((j+1) % len == i) {
                    return i;
                }
            }
        }

        return -1;
    }

}
