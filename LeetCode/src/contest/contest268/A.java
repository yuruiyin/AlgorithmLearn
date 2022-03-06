package contest.contest268;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/21
 */
public class A {

    public int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[j] != colors[i]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
