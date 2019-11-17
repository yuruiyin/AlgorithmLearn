package problem1001_1100;

import utils.PrintUtil;

import java.util.*;

public class Problem1096 {

    private boolean isLowerCaseLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public List<String> braceExpansionII(String expression) {
        Stack<String> stack = new Stack<>();
        char[] arr = expression.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '}') {
                List<String> strList = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().equals("{")) {
                    String str = stack.pop();
                    if (!str.equals(",")) {
                        strList.add(str);
                    }
                }
                stack.pop();

                Collections.reverse(strList);
                if (stack.isEmpty()) {
                    for (String str: strList) {
                        stack.push(str);
                    }
                    continue;
                }

                String top = stack.peek();
                if (top.equals("{") || top.equals(",")) {
                    for (String str: strList) {
                        stack.push(str);
                    }
                } else if (isLowerCaseLetter(top.charAt(top.length() - 1))) {
                    List<String> leftStrList = new ArrayList<>();
                    while (!stack.empty() && !stack.peek().equals("{") && !stack.peek().equals(",")) {
                        String str = stack.pop();
                        leftStrList.add(str);
                    }

                    Collections.reverse(leftStrList);
                    // 相连
                    for (String leftStr: leftStrList) {
                        for (String rightStr: strList) {
                            stack.push(leftStr + rightStr);
                        }
                    }
                }
            } else {
                if (isLowerCaseLetter(c)) {
                    // 可能不止一个字母，如连续的 abc
                    StringBuilder sb = new StringBuilder();
                    int j;
                    for (j = i; j < len; j++) {
                        if (isLowerCaseLetter(arr[j])) {
                            sb.append(arr[j]);
                        } else {
                            break;
                        }
                    }

                    // 与stack中的字符进行连接
                    List<String> leftStrList = new ArrayList<>();
                    while (!stack.empty() && !stack.peek().equals("{") && !stack.peek().equals(",")) {
                        String str = stack.pop();
                        leftStrList.add(str);
                    }

                    if (leftStrList.isEmpty()) {
                        stack.push(sb.toString());
                    } else {

                        Collections.reverse(leftStrList);
                        String curStr = sb.toString();
                        // 相连
                        for (String leftStr: leftStrList) {
                            stack.push(leftStr + curStr);
                        }
                    }

                    i = j - 1;
                } else {
                    stack.push(String.valueOf(c));
                }
            }
        }

        Set<String> set = new HashSet<>();
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        List<String> ansList = new ArrayList<>(set);
        Collections.sort(ansList);
        return ansList;
    }
    
    public static void main(String[] args) {
        PrintUtil.printStringList(new Problem1096().braceExpansionII("{a,b}{c{d,e}}"));
        PrintUtil.printStringList(new Problem1096().braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
        PrintUtil.printStringList(new Problem1096().braceExpansionII("{a,b}{c,{d,e}}"));
        PrintUtil.printStringList(new Problem1096().braceExpansionII("{a,b}c{d,e}"));
        PrintUtil.printStringList(new Problem1096().braceExpansionII("{a,b}c{d,e}f"));
    }
    
}
