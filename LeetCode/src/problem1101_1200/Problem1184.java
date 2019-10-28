package problem1101_1200;

public class Problem1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int num: distance) {
            sum += num;
        }

        int min = Math.min(start, destination);
        int max = Math.max(start, destination);

        int value = 0;
        for (int i = min; i < max; i++) {
            value += distance[i];
        }

        return Math.min(value, sum - value);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1184().distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 2));
        System.out.println(new Problem1184().distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 3));
        System.out.println(new Problem1184().distanceBetweenBusStops(new int[]{1,2,3,4}, 3, 0));

    }

}
