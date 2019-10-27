package contest.contest083;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> ansList = new ArrayList<>();

        if (n < 3) {
            return ansList;
        }

        int count = 1;
        int start = 0;
        for (int i = 1; i < n; i++) {
            char curChar = s.charAt(i);
            char prevChar = s.charAt(i-1);
            if (curChar == prevChar) {
                count++;
            } else {
                if (count >= 3) {
                    ansList.add(new ArrayList<>(Arrays.asList(start, i-1)));
                }
                count = 1;
                start = i;
            }
        }

        if (count >= 3) {
            ansList.add(new ArrayList<>(Arrays.asList(start, n-1)));
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem830().largeGroupPositions("abbxxxxzzy");
        PrintUtil.printIntListList(ansList);

        List<List<Integer>> ansList1 = new Problem830().largeGroupPositions("abc");
        PrintUtil.printIntListList(ansList1);

        List<List<Integer>> ansList2 = new Problem830().largeGroupPositions("abcdddeeeeaabbbcd");
        PrintUtil.printIntListList(ansList2);
    }
    
}
