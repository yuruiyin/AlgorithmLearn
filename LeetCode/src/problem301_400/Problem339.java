package problem301_400;

import java.util.List;

public class Problem339 {

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();

    }

    private int ansSum = 0;

    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                ansSum += nestedInteger.getInteger() * depth;
            } else {
                dfs(nestedInteger.getList(), depth + 1);
            }
        }
    }

    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return ansSum;
    }

}
