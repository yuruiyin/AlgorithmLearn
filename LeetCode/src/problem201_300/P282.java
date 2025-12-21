package problem201_300;

import java.util.*;

public class P282 {

    private int len;

    private char[] arr;

    private int target;

    private List<String> ansList;

    private char[] ops = new char[]{' ', '+', '-', '*'};

    private String getOkStr(char[] arr, char[] opArr) {
        String mergeStr = merge(arr, opArr);
        List<Long> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        long preNum = 0;
        for (int i = 0; i < mergeStr.length(); i++) {
            char c = mergeStr.charAt(i);
            if (Character.isDigit(c)) {
                if (i > 0 && mergeStr.charAt(i - 1) == '0' && preNum == 0) {
                    return null;
                }
                preNum = preNum * 10 + (c - '0');
            } else {
                opList.add(c);
                numList.add(preNum);
                preNum = 0;
            }
        }

        numList.add(preNum);
        int numCount = numList.size();
        long sum = 0;
        long pre = numList.get(0);
        char preOp = '+';
        for (int i = 1; i < numCount; i++) {
            char op = opList.get(i - 1);
            if (op == '*') {
                pre = pre * numList.get(i);
            } else {
                if (preOp == '+') {
                    sum += pre;
                    pre = numList.get(i);
                } else if (preOp == '-') {
                    sum -= pre;
                    pre = numList.get(i);
                }

                preOp = op;
            }
        }

        if (preOp == '+') {
            sum += pre;
        } else if (preOp == '-') {
            sum -= pre;
        }

        if (sum != target) {
            return null;
        }

        return mergeStr;
    }

    private String merge(char[] arr, char[] opArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < len; i++) {
            if (opArr[i - 1] != ' ') {
                sb.append(opArr[i - 1]);
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    private void dfs(int index, char[] opArr) {
        if (index == len - 1) {
            String okStr = getOkStr(arr, opArr);
            if (okStr != null) {
                ansList.add(okStr);
            }
            return;
        }

        for (char op : ops) {
            opArr[index] = op;
            dfs(index + 1, opArr);
            opArr[index] = 'n';
        }
    }

    public List<String> addOperators(String num, int target) {
        this.arr = num.toCharArray();
        this.len = arr.length;
        this.target = target;
        char[] opArr = new char[len - 1];
        Arrays.fill(opArr, 'n');
        ansList = new ArrayList<>();
        dfs(0, opArr);
        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new P282().addOperators("123", 6);
    }

}