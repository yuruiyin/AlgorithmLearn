package problem1201_1300;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem1238 {

    private List<Integer> ansList;

    private boolean isMatch(int num1, int num2) {
        int xor = num1 ^ num2;
        return (xor & (xor - 1)) == 0;
    }

    private boolean backTrack(int n, int curNum, boolean[] visited, List<Integer> tmpList) {
        if (tmpList.size() == Math.pow(2, n) - 1) {
            int lastNum = tmpList.get(tmpList.size() - 1);
            if (isMatch(lastNum, ansList.get(0))) {
                ansList.addAll(new ArrayList<>(tmpList));
                return true;
            }
            return false;
        }

        boolean isFound;
        for (int i = 0; i < n; i++) {
            // 用1异或
            int newNum = (1 << i) ^ curNum;
            if (visited[newNum]) {
                continue;
            }
            visited[newNum] = true;
            tmpList.add(newNum);
            isFound = backTrack(n, newNum, visited, tmpList);
            if (isFound) {
                return true;
            }
            tmpList.remove(tmpList.size() - 1);
            visited[newNum] = false;
        }

        return false;
    }

    public List<Integer> circularPermutation(int n, int start) {
        ansList = new ArrayList<>();
        ansList.add(start);

        if (n == 1) {
            ansList.add(start == 0 ? 1 : 0);
            return ansList;
        }

        boolean[] visited = new boolean[(int) Math.pow(2, n)];
        visited[start] = true;
        backTrack(n, start, visited, new ArrayList<>());

        return ansList;
    }
    
    public static void main(String[] args) {
        List<Integer> ansList = new Problem1238().circularPermutation(2, 3);
        PrintUtil.printIntList(ansList);

        List<Integer> ansList1 = new Problem1238().circularPermutation(3, 2);
        PrintUtil.printIntList(ansList1);
    }
    
}
