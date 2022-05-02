package problem501_600;

import java.util.LinkedList;

public class Problem591 {

    private boolean isAllUpperCase(String name) {
        if (name.length() == 0) {
            return false;
        }
        char[] arr = name.toCharArray();
        for (char c : arr) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String code) {
        char[] arr = code.toCharArray();
        int len = arr.length;
        if (arr[0] != '<' || arr[len - 1] != '>') {
            return false;
        }

        LinkedList<String> leftTagStack = new LinkedList<>();
        String firstLeftTag = null;
        String lastRightTag = null;

        for (int i = 0; i < len; i++) {
            if (arr[i] == '<') {
                if (i + "<![CDATA[".length() <= len - 4) {
                    if (code.substring(i, i + "<![CDATA[".length()).equals("<![CDATA[")) {
                        int cdataEndIdx = code.indexOf("]]>", i);
                        if (cdataEndIdx != -1) {
                            // cdata
                            i = code.indexOf("]]>", i) + 2;
                            continue;
                        }
                    }
                }
                // 标签，找到下一个'>'
                if (i + 3 >= len) {
                    return false;
                }

                int nextRightTagIdx = code.indexOf('>', i);
                if (nextRightTagIdx == -1) {
                    return false;
                }

                if (arr[i + 1] == '/') {
                    if (leftTagStack.isEmpty()) {
                        return false;
                    }
                    String rightTagName = code.substring(i + 2, nextRightTagIdx);
                    if (rightTagName.isEmpty()) {
                        return false;
                    }
                    String leftTag = leftTagStack.getLast();
                    if (!rightTagName.equals(leftTag)) {
                        return false;
                    }
                    lastRightTag = leftTagStack.pollLast();
                    i = nextRightTagIdx;
                    if (leftTagStack.isEmpty() && i != len - 1) {
                        return false;
                    }
                    continue;
                }

                String leftTagName = code.substring(i + 1, nextRightTagIdx);
                if (!isAllUpperCase(leftTagName) || leftTagName.length() > 9) {
                    return false;
                }

                if (i == 0) {
                    firstLeftTag = leftTagName;
                }
                leftTagStack.addLast(leftTagName);
                i = nextRightTagIdx;
            }
        }

        return leftTagStack.isEmpty() && firstLeftTag != null && firstLeftTag.equals(lastRightTag);
    }

    public static void main(String[] args) {
        System.out.println(new Problem591().isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }

}
