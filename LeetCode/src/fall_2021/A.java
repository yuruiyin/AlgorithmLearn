package fall_2021;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/11
 */
public class A {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int[] countArr = new int[10001];
        for (int[] arr : target) {
            for (int num : arr) {
                countArr[num]++;
            }
        }

        int ans = 0;
        for (int[] arr : source) {
            for (int num : arr) {
                if (countArr[num] > 0) {
                    countArr[num]--;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
