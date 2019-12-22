package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1286 {

    class CombinationIterator {

        private List<String> ansList;
        private int count = 0;
        private char[] arr;
        private int len;
        private int combinationLength;
        private int curIndex = 0;

        private boolean dfs(int from, StringBuilder tmpSb) {
            if (tmpSb.length() == combinationLength) {
                count++;
                ansList.add(tmpSb.toString());
                if (count >= 10001) {
                    return true;
                }
                return false;
            }

            for (int i = from; i < len; i++) {
                tmpSb.append(arr[i]);
                boolean isOver = dfs(i + 1, tmpSb);
                if (isOver) {
                    return true;
                }
                tmpSb.deleteCharAt(tmpSb.length() - 1);
            }

            return false;
        }

        public CombinationIterator(String characters, int combinationLength) {
            arr = characters.toCharArray();
            len = arr.length;
            this.combinationLength = combinationLength;
            ansList = new ArrayList<>();
            dfs(0, new StringBuilder());
        }

        public String next() {
            return ansList.get(curIndex++);
        }

        public boolean hasNext() {
            return curIndex < ansList.size();
        }
    }

    public static void main(String[] args) {
        
    }
    
}
