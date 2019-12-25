package problem701_800;

public class Problem746_1 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int nonChooseMin = 0;
        int chooseMin = cost[0];

        for (int i = 1; i < len; i++) {
            int prevChooseMin = chooseMin;
            chooseMin = Math.min(nonChooseMin, chooseMin) + cost[i];
            nonChooseMin = prevChooseMin;
        }

        return Math.min(nonChooseMin, chooseMin);
    }

}
