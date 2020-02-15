package lcof;

public class Lcof015_1 {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans++;
            }
            n >>>= 1;
        }
        return ans;
    }


}
