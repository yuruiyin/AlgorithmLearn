package doubleContest.round01;

public class Problem1066 {

    private int ansMin = Integer.MAX_VALUE;
    private int[][] workers;
    private int[][] bikes;

    private void backTrack(int workerFrom, boolean[] bikeVisited, int sum) {
        if (workerFrom == workers.length) {
            if (sum < ansMin) {
                ansMin = sum;
            }
            return;
        }

        for (int j = 0; j < bikes.length; j++) {
            if (bikeVisited[j]) {
                continue;
            }

            int distance = Math.abs(workers[workerFrom][0] - bikes[j][0]) + Math.abs(workers[workerFrom][1] - bikes[j][1]);
            if (sum + distance >= ansMin) {
                continue;
            }

            bikeVisited[j] = true;
            sum += distance;
            backTrack(workerFrom + 1, bikeVisited, sum);
            sum -= distance;
            bikeVisited[j] = false;
        }
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        this.workers = workers;
        this.bikes = bikes;
        backTrack(0, new boolean[bikes.length], 0);
        return ansMin;
    }
    
    public static void main(String[] args) {
        
    }
    
}
