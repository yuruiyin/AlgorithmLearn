package contest.contest410;

import java.util.*;

public class A {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int ans = 0;
        for (String com: commands) {
            if (com.equals("UP")) {
                ans -= n;
            } else if (com.equals("DOWN")) {
                ans += n;
            } else if (com.equals("LEFT")) {
                ans--;
            } else {
                // RIGHT
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
