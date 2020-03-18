/**
 * LintCode082
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode082 {

    public int singleNumber(int[] arr) {
        int ans = 0;
        for (int num : arr) {
            ans ^= num;
        }
        return ans;
    }

}
