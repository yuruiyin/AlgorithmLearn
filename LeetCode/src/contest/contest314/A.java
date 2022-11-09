package contest.contest314;

public class A {

    public int hardestWorker(int n, int[][] logs) {
        // 0 - n-1
        int maxTime = 0;
        int preTime = 0;
        for (int[] log : logs) {
            int leaveTime = log[1];
            int time = leaveTime - preTime;
            preTime = leaveTime;
            if (time > maxTime) {
                maxTime = time;
            }
        }

        int ansMinId = Integer.MAX_VALUE;
        preTime = 0;
        for (int[] log : logs) {
            int id = log[0];
            int leaveTime = log[1];
            int time = leaveTime - preTime;
            preTime = leaveTime;
            if (time == maxTime) {
                ansMinId = Math.min(ansMinId, id);
            }
        }
        return ansMinId;

    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
