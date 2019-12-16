package problem201_300;

import java.util.HashMap;
import java.util.Map;

public class Problem233 {

    private Map<Integer, Integer> memo;

    private int dfs(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n < 10) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        String str = String.valueOf(n);
        int high = str.charAt(0) - '0';
        int pow = (int) Math.pow(10, str.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            // 如1234就由[0,999]， 234以内的1（固定最高位1之后），以及234+1个1组成
            memo.put(n, dfs(pow - 1) + dfs(last) + last + 1);
        } else {
            memo.put(n, pow + high * dfs(pow - 1) + dfs(last));
        }

        return memo.get(n);
    }

    // 递归求解
    public int countDigitOne(int n) {
        memo = new HashMap<>();
        return dfs(n);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem233().countDigitOne(13));
//        System.out.println(new Problem233().countDigitOne(20));
//        System.out.println(new Problem233().countDigitOne(101));
//        System.out.println(new Problem233().countDigitOne(110));
        System.out.println(new Problem233().countDigitOne(8192));
    }

}
