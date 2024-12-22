package contest.contest428;

public class A {

    public int buttonWithLongestTime(int[][] events) {
        int maxTime = events[0][1];
        int maxIdx = events[0][0];
        for (int i = 1; i < events.length; i++) {
            int idx = events[i][0];
            int time = events[i][1];
            int diffTime = time - events[i - 1][1];
            if (diffTime > maxTime) {
                maxTime = diffTime;
                maxIdx = idx;
            } else if (diffTime == maxTime) {
                maxIdx = Math.min(maxIdx, idx);
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
