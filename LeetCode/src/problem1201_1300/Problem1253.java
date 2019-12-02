package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        for (int num : colsum) {
            sum += num;
        }

        if (sum != upper + lower) {
            return new ArrayList<>();
        }

        List<Integer> upList = new ArrayList<>();
        List<Integer> lowList = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(upList);
        ansList.add(lowList);

        for (int num : colsum) {
            if (num == 0) {
                upList.add(0);
                lowList.add(0);
            } else if (num == 2) {
                upList.add(1);
                lowList.add(1);
                upper--;
                lower--;
            } else {
                if (upper > lower) {
                    upList.add(1);
                    lowList.add(0);
                    upper--;
                } else {
                    upList.add(0);
                    lowList.add(1);
                    lower--;
                }
            }
        }

        if (lower != 0 || upper != 0) {
            return new ArrayList<>();
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
