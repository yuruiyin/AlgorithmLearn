package contest.contest123;

public class Problem03 {


    /**
     * 思路：逆运算，对Y进行除2和加1操作
     */
    public int brokenCalc(int x, int y) {
        int ans = 0;
        while (x < y) {
            ans++;
            if ((y & 1) == 1) {
                y++;
            } else {
                y >>>= 1;
            }
        }

        return ans + x - y;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().brokenCalc(1, 1000000000));
    }

}
