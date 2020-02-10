package contest.contest128;

public class Problem1009 {

    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                arr[i]= '1';
            } else {
                arr[i] = '0';
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans <<= 1;
            ans += (arr[i] - '0');
        }

        return ans;
    }

}
