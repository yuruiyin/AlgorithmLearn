package lcof;

public class Lcof017 {

    public int[] printNumbers(int n) {
        int count = (int) Math.pow(10, n) - 1;
        int[] ans = new int[count];

        for (int i = 0; i < count; i++) {
            ans[i] = i + 1;
        }

        return ans;
    }

}
