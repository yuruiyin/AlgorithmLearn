package interview_alibaba.round03;

import java.util.ArrayList;
import java.util.List;

public class Problem03 {

    public String removeKdigits(String num, int k) {
        char minNum = '9';
        int n = num.length();

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c < minNum) {
                minNum = c;
            }
        }

        StringBuilder sb = new StringBuilder();

        List<Integer> willRemoveIndexList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (k == 0) {
                sb.append(num, i, n - 1);
                break;
            }

            char cur = num.charAt(i);
            if (cur == minNum) {
                sb.append(cur);
                continue;
            }
            char next = num.charAt(i+1);
            if (cur > next) {
                k--;
                continue;
            }
            sb.append(cur);
        }

        sb.append(num.charAt(n-1));

        if (k > 0) {
            String tmpStr = sb.toString();
            if (tmpStr.charAt(tmpStr.length() - 1) >= tmpStr.charAt(0) || k == sb.length()) {
                sb.delete(sb.length() - k, sb.length());
            } else {
                sb.delete(sb.length() - k - 1, sb.length() - 1);
            }
        }

        String ansStr = sb.toString();
        StringBuilder sb1 = new StringBuilder();
        boolean hasNotZero = false;

        for (int i = 0; i < ansStr.length(); i++) {
            char c = ansStr.charAt(i);
            if (c != '0') {
                hasNotZero = true;
            }

            if (hasNotZero) {
                sb1.append(c);
            }
        }

        return sb1.length() == 0 ? "0" : sb1.toString();
    }
   
    public static void main(String[] args) {
        System.out.println(new Problem03().removeKdigits("1432219", 3));
        System.out.println(new Problem03().removeKdigits("1432519", 3));
        System.out.println(new Problem03().removeKdigits("10200", 1));
        System.out.println(new Problem03().removeKdigits("10", 2));
        System.out.println(new Problem03().removeKdigits("1234567890", 10));
        System.out.println(new Problem03().removeKdigits("1234567890", 9));
        System.out.println(new Problem03().removeKdigits("996414", 3));
    }
    
}
