package problem401_500;

public class Problem476 {

    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        int ans = 0;
        boolean isFoundOne = false;

        for (char c : str.toCharArray()) {
            if (c == '1' || isFoundOne) {
                ans *= 2;
                ans += (c - '0') ^ 1;
            }

            if (c == '1') {
                isFoundOne = true;
            }
        }

        return ans;
    }

}
