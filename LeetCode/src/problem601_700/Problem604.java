package problem601_700;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem604
 *
 * @author: yry
 * @date: 2020/4/9
 */
public class Problem604 {

    class StringIterator {

        class Data {
            char c;
            int count;
            Data(char c, int count) {
                this.c = c;
                this.count = count;
            }
        }

        private String str;
        private int cur;
        private int strLen;
        private List<Data> dataList;

        public StringIterator(String compressedString) {
            this.str = compressedString;
            cur = 0;
            strLen = compressedString.length();
            calcCount();
        }

        private void calcCount() {
            dataList = new ArrayList<>();
            for (int i = 0; i < strLen;) {
                int count = 0;
                int j;
                for (j = i + 1; j < strLen && Character.isDigit(str.charAt(j)); j++) {
                    count *= 10;
                    count += str.charAt(j) - '0';
                }
                dataList.add(new Data(str.charAt(i), count));
                i = j;
            }
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            Data curData = dataList.get(cur);
            char resChar = curData.c;
            if (curData.count == 1) {
                cur++;
            } else {
                curData.count--;
            }
            return resChar;
        }

        public boolean hasNext() {
            return cur < dataList.size();
        }
    }

}
