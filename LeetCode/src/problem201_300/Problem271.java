package problem201_300;

import java.util.ArrayList;
import java.util.List;

public class Problem271 {

    public class Codec {

        private static final int WORD_MAX_LEN = 4;

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs == null || strs.size() == 0) {
                return null;
            }

            // 思路就是在每个字符串前面加一个代表字符串长度的信息头，跟TCP报文类似。
            StringBuilder sb = new StringBuilder();
            for (String word : strs) {
                int len = word.length();
                String lenStr = String.format("%0" + WORD_MAX_LEN + "d", len);  //用10位int型单个单词的长度
                sb.append(lenStr).append(word);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ansList = new ArrayList<>();
            if (s == null) {
                return ansList;
            }

            int sLen = s.length();
            int i = 0;
            while (i <= sLen - WORD_MAX_LEN) {
                int wordLen = Integer.parseInt(s.substring(i, i + WORD_MAX_LEN));
                if (wordLen == 0) {
                    ansList.add("");
                } else {
                    ansList.add(s.substring(i + WORD_MAX_LEN, i + WORD_MAX_LEN + wordLen));
                }
                i = i + WORD_MAX_LEN + wordLen;
            }

            return ansList;
        }

    }

}
