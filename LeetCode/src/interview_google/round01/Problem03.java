package interview_google.round01;

import java.util.*;

public class Problem03 {

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isNumber(String s) {
        return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    public String countOfAtoms(String formula) {
        Stack<Character> stack = new Stack<>();
        int len = formula.length();
        Stack<Character> tmpStack = new Stack<>();

        int i = 0;
        while (i < len) {
            char c = formula.charAt(i);
            if (isLower(c) || isUpper(c) || c == '(') {
                stack.push(c);
                i++;
            } else if (c == ')') {
                // 右边有可能是数字
                if (i == len - 1 || !isNumber(formula.charAt(i + 1))) {
                    // ）是最后一个字符, 或者下一个字符不是数字
                    while (stack.peek() != '(') {
                        tmpStack.push(stack.pop());
                    }
                    stack.pop();

                    while (!tmpStack.isEmpty()) {
                        stack.push(tmpStack.pop());
                    }
                } else {
                    //下一个字符是数字
                    int j;
                    for (j = i + 1; j < len; j++) {
                        if (!isNumber(formula.charAt(j))) {
                            break;
                        }
                    }
                    int nextNum = Integer.parseInt(formula.substring(i + 1, j));
                    i = j;
                    while (stack.peek() != '(') {
                        tmpStack.push(stack.pop());
                    }
                    stack.pop();

                    StringBuilder sb = new StringBuilder();
                    while (!tmpStack.isEmpty()) {
                        sb.append(tmpStack.pop());
                    }

                    String str = sb.toString();
                    // str化学式乘以nextNum
                    List<String> list = new ArrayList<>();
                    for (int k = 0; k < str.length();) {
                        char c1 = str.charAt(k);
                        if (isUpper(c1)) {
                            // 往后找出这个化学式
                            int x;
                            for (x = k + 1; x < str.length(); x++) {
                                char c2 = str.charAt(x);
                                if (isUpper(c2) || isNumber(c2)) {
                                    break;
                                }
                            }
                            list.add(str.substring(k, x));
                            k = x;
                        } else if (isNumber(c1)) {
                            int x;
                            for (x = k + 1; x < str.length(); x++) {
                                char c2 = str.charAt(x);
                                if (!isNumber(c2)) {
                                    break;
                                }
                            }
                            String number = str.substring(k, x);
                            list.add(number);
                            k = x;
                        }
                    }

                    // 原本就一个符号，也要乘以倍数
                    List<String> list1 = new ArrayList<>();
                    for (int y = 0; y < list.size(); y++) {
                        String s = list.get(y);
                        if (isNumber(s)) {
                            list1.add(String.valueOf(Integer.parseInt(s) * nextNum));
                        } else {
                            list1.add(s);
                            if (y == list.size() - 1 || !isNumber(list.get(y + 1))) {
                                list1.add(String.valueOf(nextNum));
                            }
                        }
                    }

                    // 去括号乘以倍数之后重新压栈
                    for (String s: list1) {
                        for (int x = 0; x < s.length(); x++) {
                            stack.push(s.charAt(x));
                        }
                    }

                }
            } else {
                // 数字
                stack.push(c);
                i++;
            }
        }

        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }

        StringBuilder resSb = new StringBuilder();
        while (!tmpStack.isEmpty()) {
            resSb.append(tmpStack.pop());
        }

        String resStr = resSb.toString();
        Map<String, Integer> map = new TreeMap<>();
        String lastAtom = "";

        for (int k = 0; k < resStr.length();) {
            char c = resStr.charAt(k);
            if (isUpper(c)) {
                // 往后找出这个化学式
                int x;
                for (x = k + 1; x < resStr.length(); x++) {
                    char c2 = resStr.charAt(x);
                    if (isUpper(c2) || isNumber(c2)) {
                        break;
                    }
                }

                lastAtom = resStr.substring(k, x);
                if (!map.containsKey(lastAtom)) {
                    map.put(lastAtom, 0);
                }

                k = x;
                if (k > resStr.length() - 1 || !isNumber(resStr.charAt(k))) {
                    map.put(lastAtom, map.get(lastAtom) + 1);
                }
            } else if (isNumber(c)) {
                int x;
                for (x = k + 1; x < resStr.length(); x++) {
                    char c2 = resStr.charAt(x);
                    if (!isNumber(c2)) {
                        break;
                    }
                }
                String number = resStr.substring(k, x);
                map.put(lastAtom, map.get(lastAtom) + Integer.parseInt(number));
                k = x;
            }
        }

        // 不考虑0和1数字
        StringBuilder resSb1 = new StringBuilder();
        for (String atom : map.keySet()) {
            resSb1.append(atom);
            int number = map.get(atom);
            if (number > 1) {
                resSb1.append(map.get(atom));
            }
        }

        return resSb1.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem03().countOfAtoms("K4(ON(SO3)2)2"));
//        System.out.println(new Problem1219().countOfAtoms("Mg(OH)2"));
//        System.out.println(new Problem1219().countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(new Problem03().countOfAtoms("H11He49NO35B7N46Li20"));
        System.out.println(new Problem03().countOfAtoms("Be32"));


    }

}
