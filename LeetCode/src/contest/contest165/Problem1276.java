package contest.contest165;

import java.util.ArrayList;
import java.util.List;

public class Problem1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ansList = new ArrayList<>();
        if ((tomatoSlices & 1) == 1) {
            return ansList;
        }

        int x = tomatoSlices / 2 - cheeseSlices;
        if (x < 0) {
            return ansList;
        }

        int y = cheeseSlices - x;
        if (y < 0) {
            return ansList;
        }

        ansList.add(x);
        ansList.add(y);

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
