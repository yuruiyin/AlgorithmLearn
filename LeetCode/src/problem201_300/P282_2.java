package problem201_300;

import java.util.ArrayList;
import java.util.List;

public class P282_2 {

    private int len;

    private char[] arr;

    private int target;

    private List<String> ansList;

    private final char[] ops = new char[]{' ', '+', '-', '*'};
    
    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOk(char[] mergeArr, int len) {
        long preNum = 0;
        long sum = 0;
        boolean isPrePlus = true;
        for (int i = 0; i < len;) {
            char c = mergeArr[i];
            if (isDigit(c)) {
                preNum = preNum * 10 + (c - '0');
                i++;
            } else {
                if (c == '*') {
                    long curNum = 0;
                    int j;
                    for (j = i + 1; j < len;) {
                        char curC = mergeArr[j];
                        if (isDigit(curC)) {
                            curNum = curNum * 10 + (curC - '0');
                            j++;
                        } else if (curC != '*') {
                            if (isPrePlus) {
                                sum += preNum * curNum;
                            } else {
                                sum -= preNum * curNum;
                            }
                            preNum = 0;
                            break;
                        } else {
                            preNum = preNum * curNum;
                            curNum = 0;
                            j++;
                        }
                    }
                    if (j == len) {
                        preNum *= curNum;
                        break;
                    }
                    i = j;
                } else {
                    if (isPrePlus) {
                        sum += preNum;
                    } else {
                        sum -= preNum;
                    }
                    preNum = 0;
                    i++;
                    isPrePlus = c == '+';
                }
            }
        }

        if (isPrePlus) {
            sum += preNum;
        } else {
            sum -= preNum;
        }

        return sum == target;
    }

    private void dfs(int index, char[] tmpArr, int tmpArrLen) {
        if (index == len) {
            if (isOk(tmpArr, tmpArrLen)) {
                ansList.add(String.valueOf(tmpArr, 0, tmpArrLen));
            }
            return;
        }

        for (char op : ops) {
            if (op == ' ') {
                if (tmpArrLen >= 2 && tmpArr[tmpArrLen - 1] == '0' && !isDigit(tmpArr[tmpArrLen - 2]) ||
                    tmpArrLen == 1 && tmpArr[tmpArrLen - 1] == '0') {
                    continue;
                }
                tmpArr[tmpArrLen++] = arr[index];
                dfs(index + 1, tmpArr, tmpArrLen);
                tmpArrLen--;
            } else {
                tmpArr[tmpArrLen++] = op;
                tmpArr[tmpArrLen++] = arr[index];
                dfs(index + 1, tmpArr, tmpArrLen);
                tmpArrLen -= 2;
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        this.arr = num.toCharArray();
        this.len = arr.length;
        this.target = target;
        ansList = new ArrayList<>();
        char[] tmpArr = new char[len * 2];
        tmpArr[0] = num.charAt(0);
        dfs(1, tmpArr, 1);
        return ansList;
    }

    public static void main(String[] args) {
//        List<String> ansList = new P282_2().addOperators("123", 6);
//        List<String> ansList = new P282_2().addOperators("232", 8);
        List<String> ansList = new P282_2().addOperators("20", 2);
    }

}