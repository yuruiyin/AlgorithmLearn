package problem801_900;

import java.util.ArrayList;
import java.util.List;

public class Problem842 {

    public List<Integer> splitIntoFibonacci(String str) {
        int len = str.length();
        // 先确定第一个数和第二个数
        boolean isFirstZero = false;

        for (int i = 0; i < len / 2 && i < 10; i++) {
            if (isFirstZero) {
                break;
            }

            long firstNum;
            if (str.charAt(0) == '0') {
                firstNum = 0;
                isFirstZero = true;
            } else {
                firstNum = Long.parseLong(str.substring(0, i+1));
            }

            if (firstNum > Integer.MAX_VALUE) {
                break;
            }

            boolean isSecondNumFirstZero = false;
            for (int j = i + 1; j < len && j < i + 1 + 10; j++) {
                if (isSecondNumFirstZero) {
                    break;
                }

                long secondNum;
                if (str.charAt(i+1) == '0') {
                    secondNum = 0;
                    isSecondNumFirstZero = true;
                } else {
                    secondNum = Long.parseLong(str.substring(i+1, j+1));
                }

                if (secondNum > Integer.MAX_VALUE) {
                    break;
                }

                long sum = firstNum + secondNum;
                if (sum > Integer.MAX_VALUE) {
                    break;
                }

                int nextIndex = j + 1;
                boolean isFound = true;
                List<Integer> ansList = new ArrayList<>();
                long tmpFirstNum = firstNum;
                long tmpSecondNum = secondNum;
                ansList.add((int) tmpFirstNum);
                ansList.add((int) tmpSecondNum);
                while (nextIndex < len) {
                    long thirdNum = tmpFirstNum + tmpSecondNum;
                    if (thirdNum > Integer.MAX_VALUE) {
                        isFound = false;
                        break;
                    }
                    String thirdNumStr = String.valueOf(thirdNum);
                    int thirdLen = thirdNumStr.length();
                    if (nextIndex + thirdLen > len) {
                        isFound = false;
                        break;
                    }

                    if (!str.substring(nextIndex, nextIndex + thirdLen).equals(thirdNumStr)) {
                        isFound = false;
                        break;
                    }

                    ansList.add((int) thirdNum);
                    tmpFirstNum = tmpSecondNum;
                    tmpSecondNum = thirdNum;
                    nextIndex += thirdLen;
                }

                if (isFound && nextIndex == len && ansList.size() >= 3) {
                    return ansList;
                }
            }

        }

        return new ArrayList<>();
    }
    
    public static void main(String[] args) {
        new Problem842().splitIntoFibonacci("1101111");
    }

}
