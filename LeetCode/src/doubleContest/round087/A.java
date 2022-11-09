package doubleContest.round087;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class A {

    private int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    private int convert(String str) {
        int mm = Integer.parseInt(str.substring(0, 2));
        int dd = Integer.parseInt(str.substring(3, 5));
        int ans = 0;
        for (int i = 0; i < mm - 1; i++) {
            ans += arr[i];
        }
        return ans += dd;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int aliceFrom = convert(arriveAlice);
        int aliceTo = convert(leaveAlice);
        int bobFrom = convert(arriveBob);
        int bobTo = convert(leaveBob);
        boolean[] visited = new boolean[366];
        for (int i = aliceFrom; i <= aliceTo; i++) {
            visited[i] = true;
        }

        int ans = 0;
        for (int i = bobFrom; i <= bobTo; i++) {
            if (visited[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
