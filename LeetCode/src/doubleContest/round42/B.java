package doubleContest.round42;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/26
 */
public class B {

    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int n = customers.length;
        int cur = customers[0][0];

        for (int[] arr : customers) {
            int from = arr[0];
            int dis = arr[1];

            sum += Math.max(0, cur - from) + dis;
            if (cur < from) {
                cur = from;
            }
            cur += dis;
        }

        return sum / n;
    }

    public static void main(String[] args) {
        System.out.println(new B().averageWaitingTime(new int[][]{{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}}));
    }

}
