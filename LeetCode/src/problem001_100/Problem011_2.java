package problem001_100;

/**
 * Problem011_2
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class Problem011_2 {

    public int maxArea(int[] height) {
        int len = height.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int curArea = Math.min(height[i], height[j]) * (j - i);
                ansMax = Math.max(ansMax, curArea);
            }
        }
        return ansMax;
    }

}
