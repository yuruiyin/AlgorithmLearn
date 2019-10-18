package problem001_100;

import java.util.HashMap;
import java.util.Map;

public class Problem070 {

    private Map<Integer, Integer> memMap;

    private int f(int n) {
        if (n == 1 || n == 2) {
            memMap.put(n, n);
            return n;
        }

        int first = memMap.containsKey(n-1) ? memMap.get(n-1) : f(n-1);
        int second = memMap.containsKey(n-2) ? memMap.get(n-2) : f(n-2);
        int res = first + second;
        memMap.put(n, res);
        return res;
    }

    private int iteratorVersion(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int i = 3;
        int ans = 0;
        while ((i++) <= n) {
            ans = first + second;
            first = second;
            second = ans;
        }

        return ans;
    }

    public int climbStairs(int n) {
        memMap = new HashMap<>();
        return iteratorVersion(n);
//        return f(n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem070().climbStairs(1));
        System.out.println(new Problem070().climbStairs(2));
        System.out.println(new Problem070().climbStairs(3));
        System.out.println(new Problem070().climbStairs(4));
    }
}
