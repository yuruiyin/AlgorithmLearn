package contest.contest118;

public class Problem04 {

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isRationalEqual(String s, String t) {
        int dotIndexS = s.indexOf('.');
        int dotIndexT = t.indexOf('.');

        // 0.9999 和1.000是一样的
        int leftParenthesesIndexS = s.indexOf('(');
        int rightParenthesesIndexS = s.indexOf(')');

        int leftParenthesesIndexT = t.indexOf('(');
        int rightParenthesesIndexT = t.indexOf(')');

        if (leftParenthesesIndexS == -1 && leftParenthesesIndexT == -1) {
            // 都没有循环小数
            if (dotIndexS == s.length() - 1) {
                s = s + "0";
            }

            if (dotIndexT == t.length() - 1) {
                t = t + "0";
            }

            double numS = Double.parseDouble(s);
            double numT = Double.parseDouble(t);
            return numS == numT;
        }

        // 去除(0)，
        if (leftParenthesesIndexS != -1) {
            boolean isAllZero = true;
            for (int i = leftParenthesesIndexS + 1; i < rightParenthesesIndexS; i++) {
                if (s.charAt(i) != '0') {
                    isAllZero = false;
                    break;
                }
            }
            if (isAllZero) {
                s = s.substring(0, leftParenthesesIndexS);
            }
        }

        if (leftParenthesesIndexT != -1) {
            boolean isAllZero = true;
            for (int i = leftParenthesesIndexT + 1; i < rightParenthesesIndexT; i++) {
                if (t.charAt(i) != '0') {
                    isAllZero = false;
                    break;
                }
            }
            if (isAllZero) {
                t = t.substring(0, leftParenthesesIndexT);
            }
        }

        leftParenthesesIndexS = s.indexOf('(');
        rightParenthesesIndexS = s.indexOf(')');

        leftParenthesesIndexT = t.indexOf('(');
        rightParenthesesIndexT = t.indexOf(')');

        // 去除(9)
        if (leftParenthesesIndexS != -1) {
            boolean isAllNine = true;
            for (int i = leftParenthesesIndexS + 1; i < rightParenthesesIndexS; i++) {
                if (s.charAt(i) != '9') {
                    isAllNine = false;
                    break;
                }
            }
            if (isAllNine) {
                if (leftParenthesesIndexS == dotIndexS + 1) {
                    int intPart = Integer.parseInt(s.substring(0, dotIndexS)) + 1;
                    s = String.valueOf(intPart) + '.' + '0';
                } else {
                    int notRepeatPart = Integer.parseInt(s.substring(dotIndexS + 1, leftParenthesesIndexS)) + 1;
                    s = s.substring(0, dotIndexS + 1) + notRepeatPart;
                }
            }
        }

        if (leftParenthesesIndexT != -1) {
            boolean isAllNine = true;
            for (int i = leftParenthesesIndexT + 1; i < rightParenthesesIndexT; i++) {
                if (t.charAt(i) != '9') {
                    isAllNine = false;
                    break;
                }
            }
            if (isAllNine) {
                if (leftParenthesesIndexT == dotIndexT + 1) {
                    int intPart = Integer.parseInt(t.substring(0, dotIndexT)) + 1;
                    t = String.valueOf(intPart) + '.' + '0';
                } else {
                    int notRepeatPart = Integer.parseInt(t.substring(dotIndexT + 1, leftParenthesesIndexT)) + 1;
                    t = t.substring(0, dotIndexT + 1) + notRepeatPart;
                }
            }
        }

        if (dotIndexS == s.length() - 1) {
            s = s + "0";
        }

        if (dotIndexT == t.length() - 1) {
            t = t + "0";
        }

        leftParenthesesIndexS = s.indexOf('(');
        rightParenthesesIndexS = s.indexOf(')');

        leftParenthesesIndexT = t.indexOf('(');
        rightParenthesesIndexT = t.indexOf(')');

        if (leftParenthesesIndexS == -1 && leftParenthesesIndexT == -1) {
            // 都没有循环小数
            double numS = Double.parseDouble(s);
            double numT = Double.parseDouble(t);
            return numS == numT;
        }

        if (leftParenthesesIndexS == -1) {
            // 一个有循环小数，一个没有, 0.99999 等于1.0
            int pointIndexT = t.indexOf('.');
            for (int i = pointIndexT + 1; i < t.length(); i++) {
                if (isNum(t.charAt(i)) && t.charAt(i) != '9') {
                    return false;
                }
            }

            // t小数部分权威9
            double tNum = Double.parseDouble(t.substring(0, dotIndexT)) + 1;
            double sNum = Double.parseDouble(s);
            return tNum == sNum;
        }

        if (rightParenthesesIndexT == -1) {
            // 一个有循环小数，一个没有, 0.99999 等于1.0
            int pointIndexS = s.indexOf('.');
            for (int i = pointIndexS + 1; i < s.length(); i++) {
                if (isNum(s.charAt(i)) && s.charAt(i) != '9') {
                    return false;
                }
            }

            // s小数部分权威9
            double sNum = Double.parseDouble(s.substring(0, dotIndexS)) + 1;
            double tNum = Double.parseDouble(t);
            return tNum == sNum;
        }

        // 都有循环小数

        // 整数部分不相等
        if (!s.substring(0, dotIndexS).equals(t.substring(0, dotIndexT))) {
            return false;
        }

        StringBuilder sSb = new StringBuilder(s.substring(dotIndexS+1, leftParenthesesIndexS));
        for (int i = 0; i < 10; i++) {
            sSb.append(s.substring(leftParenthesesIndexS+1, rightParenthesesIndexS));
        }

        StringBuilder tSb = new StringBuilder(t.substring(dotIndexT+1, leftParenthesesIndexT));
        for (int i = 0; i < 10; i++) {
            tSb.append(t.substring(leftParenthesesIndexT+1, rightParenthesesIndexT));
        }

        return sSb.substring(0, 10).equals(tSb.substring(0, 10));

    }

}
