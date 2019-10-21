package interview_bytedance.round06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem02 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (numRows == 0) {
            return ansList;
        }

        if (numRows == 1) {
            ansList.add(new ArrayList<>(Collections.singletonList(1)));
            return ansList;
        }

        if (numRows == 2) {
            ansList.add(new ArrayList<>(Collections.singletonList(1)));
            ansList.add(new ArrayList<>(Arrays.asList(1,1)));
            return ansList;
        }

        ansList.add(new ArrayList<>(Collections.singletonList(1)));
        ansList.add(new ArrayList<>(Arrays.asList(1,1)));

        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> lastList = ansList.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(lastList.get(j-1) + lastList.get(j));
            }
            list.add(1);
            ansList.add(list);
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
