package doubleContest.round12;

import java.util.*;

public class Problem01 {

    class Leaderboard {

        class Data {
            int playerId;
            int score;
            Data(int playerId, int score) {
                this.playerId = playerId;
                this.score = score;
            }
        }

        class CustomCmp implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }

        private Map<Integer, Integer> map = new HashMap<>();
        private int[] arr;
        private PriorityQueue<Data> queue;

        public Leaderboard() {
            queue = new PriorityQueue<>();
            arr = new int[10001];
        }

        public void addScore(int playerId, int score) {
//            if (map.containsKey(playerId)) {
//                map.put(playerId, map.get(playerId) + score);
//            } else {
//                map.put(playerId, score);
//            }
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
