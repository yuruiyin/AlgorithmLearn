package problem001_100;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem068 {

    private String getLineStr(List<String> lineStrList, int maxWidth) {
        // 两端对齐，空格均匀分布，如果不能均匀，则左侧放置的空格数要多于右侧的空格数。
        StringBuilder ansSb = new StringBuilder();
        int wordCount = lineStrList.size();
        int charCount = 0;

        for (String word: lineStrList) {
            charCount += word.length();
        }

        int spaceCharCount = maxWidth - charCount;

        if (wordCount == 1) {
            // 就一个单词,  右侧加上一些空格即可
            ansSb.append(lineStrList.get(0));
            while ((spaceCharCount--) > 0) {
                ansSb.append(' ');
            }

            return ansSb.toString();
        }

        int spaceBlockCount = wordCount - 1;
        int spaceCharCountPerBlock = spaceCharCount / spaceBlockCount;
        int leftSpaceCharCount = spaceCharCount % spaceBlockCount;
        List<String> spaceBlockList = new ArrayList<>();
        StringBuilder spaceBlockSb = new StringBuilder();

        while ((spaceCharCountPerBlock--) > 0) {
            spaceBlockSb.append(' ');
        }

        for (int i = 0; i < spaceBlockCount; i++, leftSpaceCharCount--) {
            String spaceBlock;
            if (leftSpaceCharCount > 0) {
                StringBuilder tmpSb = new StringBuilder(spaceBlockSb);
                spaceBlock = tmpSb.append(' ').toString();
            } else {
                spaceBlock = spaceBlockSb.toString();
            }
            spaceBlockList.add(spaceBlock);
        }

        for (int i = 0; i < wordCount; i++) {
            ansSb.append(lineStrList.get(i));
            if (i < wordCount -1) {
                // 最后一个单词后面不加空格
                ansSb.append(spaceBlockList.get(i));
            }
        }

        return ansSb.toString();
    }

    private String getLastLineStr(List<String> lineStrList, int maxWidth) {
        // 文本的最后一行应为左对齐，且单词之间不插入额外的空格。即单词之间就一个空格, 最后一个单词后面填满空格到行的最大字符数
        StringBuilder ansSb = new StringBuilder();
        int wordCount = lineStrList.size();
        int charCount = 0;
        int midSpaceCount = wordCount - 1;

        for (String word: lineStrList) {
            charCount += word.length();
        }

        int suffixSpaceCount = maxWidth - charCount - midSpaceCount;
        for (int i = 0; i < wordCount; i++) {
            ansSb.append(lineStrList.get(i));
            if (i == wordCount - 1) {
                while ((suffixSpaceCount--) > 0) {
                    ansSb.append(' ');
                }
            } else {
                ansSb.append(' ');
            }
        }

        return ansSb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordCount = words.length;
        List<String> ansList = new ArrayList<>();

        List<String> lineStrList = new ArrayList<>();
        int charCount = 0;
        for (int i = 0; i < wordCount; i++) {
            String word = words[i];
            if (charCount + word.length() <= maxWidth) {
                lineStrList.add(word);
                charCount += word.length() + 1;
            } else {
                ansList.add(getLineStr(lineStrList, maxWidth));
                lineStrList.clear();
                lineStrList.add(word);
                charCount = word.length() + 1;
            }

            if (i == wordCount - 1) {
                // 最后一行
                ansList.add(getLastLineStr(lineStrList, maxWidth));
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new Problem068().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        PrintUtil.printStringList(ansList);

        List<String> ansList1 = new Problem068().fullJustify(new String[]{
                "What","must","be","acknowledgment","shall","be"
        }, 16);
        PrintUtil.printStringList(ansList1);

        List<String> ansList2 = new Problem068().fullJustify(new String[]{
                        "Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"
        }, 20);
        PrintUtil.printStringList(ansList2);
    }

}


//    输入:
//    words = ["This", "is", "an", "example", "of", "text", "justification."]
//    maxWidth = 16
//    输出:
//            [
//               "This    is    an",
//               "example  of text",
//               "justification.  "
//            ]
