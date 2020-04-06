package problem301_400;

import java.util.List;

public class Problem385 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

    private int getInteger(char[] arr, int start, int end) {
        int newStart = start;
        int sign = 1;
        if (arr[start] == '-') {
            newStart++;
            sign = -1;
        }
        int ans = 0;
        for (int i = newStart; i <= end; i++) {
            ans *= 10;
            ans += arr[i] - '0';
        }
        return sign * ans;
    }

    private NestedInteger dfs(char[] arr, int start, int end) {
        if (arr[start] != '[') {
            // 说明就一个数字
            return new NestedInteger(getInteger(arr, start, end));
        }

        int leftCount = 0;
        int rightCount = 0;
        NestedInteger res = new NestedInteger();
        int curStart = start + 1;
        for (int i = start + 1; i <= end - 1; i++) {
            if (arr[i] == '[') {
                leftCount++;
            } else if (arr[i] == ']') {
                rightCount++;
            } else if (arr[i] == ',') {
                if (leftCount == rightCount) {
                    res.add(dfs(arr, curStart, i - 1));
                    leftCount = 0;
                    rightCount = 0;
                    curStart = i + 1;
                }
            }
        }

        // 最后一个
        if (curStart <= end - 1) {
            res.add(dfs(arr, curStart, end - 1));
        }
        return res;
    }

    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        // 递归求解
        return dfs(s.toCharArray(), 0, s.length() - 1);
    }

}
