package problem401_500;

import java.util.Map;

public class Problem492 {

    public int[] constructRectangle(int area) {
        int[] ansArr = new int[2];
        for (int i = (int) Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                ansArr[0] = area / i;
                ansArr[1] = i;
                return ansArr;
            }
        }
        return null;
    }

}
