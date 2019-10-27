package contest.contest160;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem01 {

    interface CustomFunction {
        int f(int x, int y);
    }

    static class CustomFunctionImpl implements CustomFunction {

        @Override
        public int f(int x, int y) {
            return x * y;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ansList = new ArrayList<>();

        for (int i = 1;;i++) {
            if (customfunction.f(i,1) > z) {
                break;
            }
            for (int j = 1;;j++) {
                if (customfunction.f(i, j) > z) {
                    break;
                }
                if (customfunction.f(i, j) == z) {
                    ansList.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem01().findSolution(new CustomFunctionImpl(), 5);

        PrintUtil.printIntListList(ansList);
    }
    
}
