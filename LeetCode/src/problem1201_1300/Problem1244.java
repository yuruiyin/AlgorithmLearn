package problem1201_1300;

import java.util.Arrays;

public class Problem1244 {

    class Leaderboard {

        private int[] arr;

        public Leaderboard() {
            arr = new int[10001];
        }

        public void addScore(int playerId, int score) {
            arr[playerId] += score;
        }

        public int top(int K) {
            int[] tmpArr = Arrays.copyOfRange(arr, 0, arr.length);
            Arrays.sort(tmpArr);
            int sum = 0;
            for (int i = arr.length - 1; i >= arr.length - K; i--) {
                sum += tmpArr[i];
            }

            return sum;
        }

        public void reset(int playerId) {
            arr[playerId] = 0;
        }
    }

    public static void main(String[] args) {

    }
    
}
