package contest.contest259;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/19
 */
public class A {

    // "++X"、"X++"、"--X" 或 "X--"
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String str : operations) {
            if (str.equals("++X") || str.equals("X++")) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }

}
