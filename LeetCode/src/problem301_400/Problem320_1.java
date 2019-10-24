package problem301_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem320_1 {

    class CustomChar {
        char c;
        int indexInWord;
        CustomChar(char c, int indexInWord) {
            this.c = c;
            this.indexInWord = indexInWord;
        }
    }

    private void backTrack(int from, char[] word, List<CustomChar> tmpList, List<List<CustomChar>> ansList) {
        ansList.add(new ArrayList<>(tmpList));

        int len = word.length;
        for (int i = from; i < len; i++) {
            tmpList.add(new CustomChar(word[i], i));
            backTrack(i + 1, word, tmpList, ansList);
            tmpList.remove(tmpList.size() - 1);
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

        List<List<CustomChar>> tmpAnsList = new ArrayList<>();
        backTrack(0, wordArr, new ArrayList<>(), tmpAnsList);

        List<String> ansList = new ArrayList<>();
        for (List<CustomChar> charList: tmpAnsList) {
            StringBuilder sb = new StringBuilder();
            int size = charList.size();

            if (size == 0) {
                ansList.add(len + "");
                continue;
            }

            // 处理第一个字母前面的数字
            CustomChar firstChar = charList.get(0);
            if (firstChar.indexInWord != 0) {
                sb.append(firstChar.indexInWord);
            }
            for (int i = 0; i < size - 1; i++) {
                CustomChar curChar = charList.get(i);
                CustomChar nextChar = charList.get(i + 1);
                sb.append(curChar.c);
                int diff = nextChar.indexInWord - curChar.indexInWord;
                if (diff > 1) {
                    sb.append(diff - 1);
                }
            }

            //处理最后一个字母后面的数字
            CustomChar lastChar = charList.get(size - 1);
            sb.append(lastChar.c);
            int diff = len - lastChar.indexInWord;
            if (diff > 1) {
                sb.append(diff - 1);
            }

            ansList.add(sb.toString());
        }

        return ansList;
    }
    
    public static void main(String[] args) {
//                List<String> ansList = new Problem320_1().generateAbbreviations("interaction");
        List<String> ansList = new Problem320_1().generateAbbreviations("word");
//        List<String> ansList = new Problem320_1().generateAbbreviations("a");

        System.out.println("大小： " + ansList.size());

        for (String str: ansList) {
            System.out.print(str + ",");
        }

        System.out.println();
    }

}
