package problem301_400;

import java.util.List;

public class Problem339_1 {

    public interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();

    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int ansSum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                ansSum += nestedInteger.getInteger() * depth;
            } else {
                ansSum += dfs(nestedInteger.getList(), depth + 1);
            }
        }

        return ansSum;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }


}
