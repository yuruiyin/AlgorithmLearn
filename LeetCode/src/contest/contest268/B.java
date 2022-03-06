package contest.contest268;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/21
 */
public class B {

    public int wateringPlants(int[] plants, int capacity) {
        int cur = capacity;
        int ans = 0;
        for (int i = 0; i < plants.length; i++) {
            if (cur >= plants[i]) {
                cur -= plants[i];
                ans++;
            } else {
                ans += i + 1 + i;
                cur = capacity;
                cur -= plants[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B().wateringPlants(new int[]{2,2,3,3}, 5));
    }

}
