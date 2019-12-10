package problem301_400;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem341 {

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();

    }

    public class NestedIterator implements Iterator<Integer> {

        private LinkedList<NestedInteger> stack;
        private Integer num;

        public NestedIterator(List<NestedInteger> nestedList) {
            int size = nestedList.size();
            stack = new LinkedList<>();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return num;
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty()) {
                return false;
            }

            boolean hasNext = false;
            while (!stack.isEmpty()) {
                NestedInteger top = stack.pop();
                if (top.isInteger()) {
                    num = top.getInteger();
                    hasNext = true;
                    break;
                }

                List<NestedInteger> list = top.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }

            return hasNext;
        }
    }

}
