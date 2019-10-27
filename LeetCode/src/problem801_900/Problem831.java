package problem801_900;

import java.util.ArrayList;
import java.util.List;

public class Problem831 {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private String handleTelNum(String s) {
        boolean isWorldNum = false;
        int len = s.length();

        List<Character> numList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                numList.add(c);
            }
        }

        int numCount = numList.size();
        if (numCount > 10) {
            isWorldNum = true;
        }

        StringBuilder lastFourNum = new StringBuilder();
        for (int i = numCount - 4; i < numCount; i++) {
            lastFourNum.append(numList.get(i));
        }

        StringBuilder ansSb = new StringBuilder();

        if (isWorldNum) {
            int starCount = numCount - 10;
            StringBuilder sb = new StringBuilder("+");
            while ((starCount--) > 0) {
                sb.append('*');
            }
            sb.append('-');
            ansSb.append(sb);
        }

        ansSb.append("***-***-");
        ansSb.append(lastFourNum);

        return ansSb.toString();
    }

    private String handleEmail(String s) {
        String ansStr = s.toLowerCase();
        int atIndex = ansStr.indexOf('@');
        return ansStr.charAt(0) + "*****" + ansStr.substring(atIndex - 1);
    }

    public String maskPII(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        if (!isLetter(s.charAt(0))) {
            // 电话号码
            return handleTelNum(s);
        } else {
            // 邮箱
            return handleEmail(s);
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem831().maskPII("LeetCode@LeetCode.com"));
//        System.out.println(new Problem831().maskPII( "AB@qq.com"));
//        System.out.println(new Problem831().maskPII( "1(234)567-890"));
//        System.out.println(new Problem831().maskPII( "86-(10)12345678"));
//        System.out.println(new Problem831().maskPII( "+(501321)-50-23431"));
        System.out.println(new Problem831().maskPII( "mkGQpDSXbRSShWzcNxOzMoWFo@eVRzwumi.Dfdim"));

    }
    
}
