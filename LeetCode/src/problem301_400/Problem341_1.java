package problem301_400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem341_1 {

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();

    }

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> numList;
        private int curIndex;
        private int size;

        public NestedIterator(List<NestedInteger> nestedList) {
            numList = new ArrayList<>();
            dfs(nestedList);
            curIndex = 0;
            size = numList.size();
        }

        private void dfs(List<NestedInteger> nestedList) {
            if (nestedList == null) {
                return;
            }

            for (NestedInteger nestedInteger: nestedList) {
                if (nestedInteger.isInteger()) {
                    numList.add(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return numList.get(curIndex++);
        }

        @Override
        public boolean hasNext() {
            return curIndex < size;
        }
        
    }

}
