package problem201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P282_1 {

    private int len;

    private char[] arr;

    private int target;

    private List<String> ansList;

    private char[] ops = new char[]{' ', '+', '-', '*'};

    private boolean isOk(StringBuilder mergeStr) {
        char[] mergeArr = mergeStr.toString().toCharArray();
        List<Long> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        long preNum = 0;
        for (int i = 0; i < mergeArr.length; i++) {
            char c = mergeArr[i];
            if (Character.isDigit(c)) {
                if (i > 0 && mergeArr[i - 1] == '0' && preNum == 0) {
                    return false;
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

        return sum == target;
    }

    private void dfs(int index, StringBuilder tmpSb) {
        if (index == len) {
            if (isOk(tmpSb)) {
                ansList.add(tmpSb.toString());
            }
            return;
        }

        for (char op : ops) {
            if (op == ' ') {
                dfs(index + 1, tmpSb.append(arr[index]));
                tmpSb.deleteCharAt(tmpSb.length() - 1);
            } else {
                dfs(index + 1, tmpSb.append(op).append(arr[index]));
                tmpSb.deleteCharAt(tmpSb.length() - 1);
                tmpSb.deleteCharAt(tmpSb.length() - 1);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        this.arr = num.toCharArray();
        this.len = arr.length;
        this.target = target;
        ansList = new ArrayList<>();
        dfs(1, new StringBuilder("" + num.charAt(0)));
        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new P282_1().addOperators("123", 6);
    }

}