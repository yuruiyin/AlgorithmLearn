package problem301_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem320 {

    class CustomChar {
        char c;
        int indexInWord;
        CustomChar(char c, int indexInWord) {
            this.c = c;
            this.indexInWord = indexInWord;
        }
    }

    private String charListToString(List<CustomChar> charList, int n) {
        StringBuilder sb = new StringBuilder();
        for (CustomChar customChar: charList) {
            sb.append(customChar.c);
        }

        int size = charList.size();
        if (size == 0) {
            sb.append(n);
        } else {
            int lastCharIndexInWord = charList.get(size - 1).indexInWord;
            if (lastCharIndexInWord < n-1) {
                // 后面要补数字
                sb.append(n - lastCharIndexInWord - 1);
            }
        }

        return sb.toString();
    }

    private char int2char(int num) {
        return (char) (num + '0');
    }

    private List<Integer> int2List(int num) {
        List<Integer> ansList = new ArrayList<>();

        while (num > 0) {
            ansList.add(num % 10);
            num /= 10;
        }

        Collections.reverse(ansList);

        return ansList;
    }

    private void backTrack(int from, char[] word, List<CustomChar> tmpList, List<String> ansList) {
        ansList.add(charListToString(new ArrayList<>(tmpList), word.length));

        int len = word.length;
        for (int i = from; i < len; i++) {
            int addedNumBitCount = 0;
            if (tmpList.size() == 0) {
                if (i > 0) {
                    List<Integer> intList = int2List(i);
                    for (Integer tmpNum : intList) {
                        tmpList.add(new CustomChar(int2char(tmpNum), i));
                    }
                    addedNumBitCount = intList.size();
                }
            } else {
                int lastCharIndexInWord = tmpList.get(tmpList.size() - 1).indexInWord;
                int diff = i - lastCharIndexInWord - 1;
                if (diff > 0) {
                    //需要考虑diff是多位数的情形
                    List<Integer> intList = int2List(diff);
                    for (Integer tmpNum : intList) {
                        tmpList.add(new CustomChar(int2char(tmpNum), i));
                    }
                    addedNumBitCount = intList.size();
                }
            }

            tmpList.add(new CustomChar(word[i], i));
            backTrack(i + 1, word, tmpList, ansList);
            tmpList.remove(tmpList.size() - 1);
            while ((addedNumBitCount)-- > 0) {
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public List<String> generateAbbreviations(String word) {
        int len = word.length();

        if (len == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }

        char[] wordArr = new char[len];

        for (int i = 0; i < len; i++) {
            wordArr[i] = word.charAt(i);
        }

        List<String> ansList = new ArrayList<>();

        backTrack(0, wordArr, new ArrayList<>(), ansList);

        return ansList;
    }
    
    public static void main(String[] args) {
//        List<String> ansList = new Problem320().generateAbbreviations("interaction");
//        List<String> ansList = new Problem320().generateAbbreviations("");
        List<String> ansList = new Problem320().generateAbbreviations("a");

        System.out.println("大小： " + ansList.size());
        
        for (String str: ansList) {
            System.out.print(str + ",");
        }
        
        System.out.println();
    }
    
}
