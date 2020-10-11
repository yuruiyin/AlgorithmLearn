package pre01;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/29
 */
public class A {

    /**
     * @param arr: the positions of trees.
     * @param d: the minimum beautiful interval.
     * @return: the minimum number of trees to remove to make trees beautiful.
     */
    public int treePlanning(int[] arr, int d) {
        // write your code here.
        int len = arr.length;
        int pre = arr[0];
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] - pre >= d) {
                pre = arr[i];
                continue;
            }
            ans++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new A().treePlanning(new int[]{1,2,3,5,6}, 2));
    }

}
