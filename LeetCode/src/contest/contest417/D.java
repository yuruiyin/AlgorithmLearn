package contest.contest417;

public class D {

    private char preChar(char c) {
        return c == 'a' ? 'z' : (char) (c - 1);
    }

    public char kthCharacter(long k, int[] operations) {
        if (k == 1) {
            return 'a';
        }

        long cur = 1;
        int targetIdx = -1;
        for (int i = 0; i < operations.length; i++) {
            if (cur >= k) {
                break;
            }

            cur <<= 1L;
            targetIdx = i;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            long curK = k - 1;
            char curC = c;
            for (int i = targetIdx; i >= 0; i--) {
                if (curK < (1L << i)) {
                    continue;
                }
                int op = operations[i];
                curK -= (1L << i);
                if (op == 1) {
                    curC = preChar(curC);
                }
            }
            if (curC == 'a') {
                return c;
            }
        }

        return 'a';
    }

    public static void main(String[] args) {
        System.out.println(new D().kthCharacter(10, new int[]{0,1,0,1}));
        System.out.println(new D().kthCharacter(11, new int[]{0,1,1,1}));
    }

}
