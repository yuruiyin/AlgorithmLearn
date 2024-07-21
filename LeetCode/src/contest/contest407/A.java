package contest.contest407;

public class A {

    public int minChanges(int n, int k) {
        if (n < k) {
            return -1;
        }

        if (n == k) {
            return 0;
        }


        String nStr = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
        String kStr = new StringBuilder(Integer.toBinaryString(k)).reverse().toString();

        char[] nBitArr = nStr.toCharArray();
        char[] kBitArr = kStr.toCharArray();
        int ans = 0;

        for (int i = 0; i < kBitArr.length; i++) {
            if (kBitArr[i] == '1' && nBitArr[i] == '0') {
                return -1;
            }

            if (kBitArr[i] == '0' && nBitArr[i] == '1') {
                ans++;
            }
        }

        for (int i = kBitArr.length; i < nBitArr.length; i++) {
            if (nBitArr[i] == '1') {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
