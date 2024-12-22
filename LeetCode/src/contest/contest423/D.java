package contest.contest423;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int countKReducibleNumbers(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int oneBitCount = 0;
        for (char c : arr) {
            if (c == '1') {
                oneBitCount++;
            }
        }

        if (k == 1) {
            return oneBitCount > 1 ? len : len - 1;
        }

        // todo
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
