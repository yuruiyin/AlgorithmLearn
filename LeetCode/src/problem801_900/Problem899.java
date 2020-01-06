package problem801_900;

import java.util.Arrays;

public class Problem899 {

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        int len = s.length();
        String minS = s;
        for (int i = 1; i < len; i++) {
            String tmpS = s.substring(i) + s.substring(0, i);
            if (tmpS.compareTo(minS) < 0) {
                minS = tmpS;
            }
        }

        return minS;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem899().orderlyQueue("abaca", 2));
    }

}
