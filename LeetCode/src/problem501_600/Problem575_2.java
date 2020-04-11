package problem501_600;

/**
 * Problem575_2
 *
 * @author: yry
 * @date: 2020/4/8
 */
public class Problem575_2 {

    public int distributeCandies(int[] candies) {
        int half = candies.length >>> 1;
        int ans = 0;
        boolean[] visited = new boolean[200001];
        for (int candy : candies) {
            candy += 100000;
            if (!visited[candy]) {
                ans++;
                if (ans == half) {
                    return ans;
                }
            }
            visited[candy] = true;
        }

        return ans;
    }

}
