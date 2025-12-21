package contest.contest443;

public class A {

    public int[] minCosts(int[] cost) {
        int len = cost.length;
        int[] ansArr = new int[len];
        int preMinCost = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (cost[i] >= preMinCost) {
                ansArr[i] = preMinCost;
            } else {
                ansArr[i] = cost[i];
                preMinCost = cost[i];
            }
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
