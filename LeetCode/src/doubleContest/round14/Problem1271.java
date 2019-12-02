package doubleContest.round14;

import java.util.HashSet;
import java.util.Set;

public class Problem1271 {

    public String toHexspeak(String numStr) {
        StringBuilder hexSb = new StringBuilder();
        long num = Long.parseLong(numStr);

        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

        while (num > 0) {
            int tmp = (int) (num % 16);
            if (tmp >= 10) {
                hexSb.append(arr[tmp-10]);
            } else {
                hexSb.append(tmp);
            }

            num /= 16;
        }

        StringBuilder ansHexSb = hexSb.reverse();

        for (int i = 0; i < ansHexSb.length(); i++) {
            if (ansHexSb.charAt(i) == '0') {
                ansHexSb.replace(i, i+1, "O");
            } else if (ansHexSb.charAt(i) == '1') {
                ansHexSb.replace(i, i+1, "I");
            }
        }

        for (int i = 0; i < ansHexSb.length(); i++) {
            char c = ansHexSb.charAt(i);
            if (c >= '2' && c <= '9') {
                return "ERROR";
            }
        }

        return ansHexSb.toString();
    }
    
    public static void main(String[] args) {

    }
    
}
