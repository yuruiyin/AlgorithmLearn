package problem101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<>(Collections.singleton(1));
        }

        if (rowIndex == 1) {
            return new ArrayList<>(Arrays.asList(1, 1));
        }

        List<Integer> prevRowList = new ArrayList<>(Arrays.asList(1, 1));

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> curRowList = new ArrayList<>();
            curRowList.add(1);
            for (int j = 1; j < i; j++) {
                curRowList.add(prevRowList.get(j-1) + prevRowList.get(j));
            }
            curRowList.add(1);
            if (i == rowIndex) {
                return curRowList;
            }

            prevRowList = curRowList;
        }

        return null;
    }
    
    public static void main(String[] args) {

    }
    
}
