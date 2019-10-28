package doubleContest.round09;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem03 {

    public int smallestCommonElement(int[][] mat) {
        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < mat[0].length; j++) {
            set.add(mat[0][j]);
        }

        for(int i = 1; i < mat.length; i++) {
            Set<Integer> tmpSet = new HashSet<>();
            for (int j = 0; j < mat[0].length; j++) {
                if (set.contains(mat[i][j])) {
                    tmpSet.add(mat[i][j]);
                }
            }

            set.clear();;
            set.addAll(tmpSet);
        }

        try {
            return Collections.min(set);
        } catch (Exception e){
            return -1;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().smallestCommonElement(new int[][]{
                {1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}
        }));
    }
    
}
