package problem901_1000;

public class Problem903 {

    private static final int MOD = 1000000007;

    private int ansCount = 0;

    private void backTracking(String s, int index, int lastNum, boolean[] visited) {
        if (index == s.length()) {
            int start = 0;
            int end = s.length();
            if (s.charAt(index - 1) == 'D') {
                // 当前这个数要比lastNum小
                end = lastNum - 1;
            } else {
                // 当前这个数要比lastNum大
                start = lastNum + 1;
            }

            for (int i = start; i <= end; i++) {
                if (!visited[i]) {
                    ansCount = (ansCount + 1) % MOD;
                }
            }
            return;
        }

        int start = 0;
        int end = s.length();
        if (index == 0) {
            if (s.charAt(0) == 'D') {
                start = 1;
            } else {
                end = s.length() - 1;
            }

        } else {
            char lastChar = s.charAt(index - 1);
            if (lastChar == 'D') {
                // 当前数要比lastNum小
                end = lastNum - 1;
            } else {
                // 当前数要比lastNum大
                start = lastNum + 1;
            }
        }

        for (int i = start; i <= end; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backTracking(s, index + 1, i, visited);
            visited[i] = false;
        }
    }

    public int numPermsDISequence(String S) {
        backTracking(S, 0, -1, new boolean[S.length() + 1]);
        return ansCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem903().numPermsDISequence("DID"));
        System.out.println(new Problem903().numPermsDISequence("IDDDIIDIIIIIIIIDIDID"));
    }
    
}
