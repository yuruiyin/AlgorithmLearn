package problem001_100;

import java.util.HashSet;
import java.util.Set;

public class Problem065 {

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isNumber(String s) {
        String s1 = s.trim();
        int len = s1.length();
        if (len == 0) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (char c = '0'; c <= '9'; c++) {
            set.add(c);
        }
        set.add('e');
        set.add('+');
        set.add('-');
        set.add('.');

        int eCount = 0;
        int pointCount = 0;
        int numCount = 0; // 数字的个数，没有数字是不合法的
        for (int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            // 1) 只能包含 0-9, e, +, -, .
            if (!set.contains(c)) {
                return false;
            }

            if (isNum(c)) {
                numCount++;
            }

            // 2) e的次数最多是1个, 小数点.的个数也最多是1个
            // 3）e的前面都必须跟着数字或者小数点
            // 4）小数点的后面必须跟着数字或者e
            // 5) e后面不能出现小数点
            // 6) e前面和和面必须有数字
            if (c == 'e') {
                eCount++;
                if (eCount > 1) {
                    return false;
                }

                if (i == 0 || i == len - 1) {
                    return false;
                }

                // e后面不能出现小数点
                for (int j = i + 1; j < len; j++) {
                    if (s1.charAt(j) == '.') {
                        return false;
                    }
                }

                // e前面和和面必须有数字
                boolean hasNum = false;
                for (int j = 0; j < i; j++) {
                    if (isNum(s1.charAt(j))) {
                        hasNum = true;
                        break;
                    }
                }

                if (!hasNum) {
                    return false;
                }

                hasNum = false;
                for (int j = i + 1; j < len; j++) {
                    if (isNum(s1.charAt(j))) {
                        hasNum = true;
                        break;
                    }
                }

                if (!hasNum) {
                    return false;
                }
            }

            if (c == '.') {
                pointCount++;
                if (pointCount > 1) {
                    return false;
                }

                if (len == 1) {
                    return false;
                }

                if (i < len - 1 && (!isNum(s1.charAt(i+1)) && s1.charAt(i+1) != 'e')) {
                    return false;
                }
            }

            // 6) +,-的前面必须处在第一个位置或者前面是e，后面必须是数字
            if (isSign(c)) {
                // 符号不在第一个位置，且前面不是e，不合法
                if (i > 0 && s1.charAt(i-1) != 'e') {
                    return false;
                }

                // 符号在最后一个位置或者符号后面不是数字或者小数点
                if (i == len - 1 || (!isNum(s1.charAt(i+1)) && s1.charAt(i+1) != '.')) {
                    return false;
                }
            }
        }

        return numCount != 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem065().isNumber("0"));
        System.out.println(new Problem065().isNumber(" 0.1 "));
        System.out.println(new Problem065().isNumber("abc"));
        System.out.println(new Problem065().isNumber("1 a"));
        System.out.println(new Problem065().isNumber("2e10"));
        System.out.println(new Problem065().isNumber(" -90e3   "));
        System.out.println(new Problem065().isNumber(" 1e"));
        System.out.println(new Problem065().isNumber("e3"));
        System.out.println(new Problem065().isNumber(" 6e-1"));
        System.out.println(new Problem065().isNumber(" 99e2.5 "));
        System.out.println(new Problem065().isNumber("53.5e93"));
        System.out.println(new Problem065().isNumber(" --6 "));
        System.out.println(new Problem065().isNumber("-+3"));
        System.out.println(new Problem065().isNumber("95a54e53"));


        System.out.println(new Problem065().isNumber(".1")); // true
        System.out.println(new Problem065().isNumber("3.")); // true
        System.out.println(new Problem065().isNumber("+.8")); // true
        System.out.println(new Problem065().isNumber("+.")); // false
        System.out.println(new Problem065().isNumber("46.e3")); // true
        System.out.println(new Problem065().isNumber(".e1")); // false

    }
    
}
