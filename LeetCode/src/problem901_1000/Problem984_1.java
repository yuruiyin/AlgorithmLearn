package problem901_1000;

public class Problem984_1 {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A > 0 && B > 0) {
            if (A > B) {
                sb.append("aab");
                A -= 2;
                B--;
            } else if (A == B) {
                for (int i = 0; i < A; i++) {
                    sb.append("ab");
                }
                A = 0;
                B = 0;
            } else {
                sb.append("bba");
                A--;
                B -= 2;
            }
        }

        if (A != 0) {
           for (int i = 0; i < A; i++) {
               sb.append("a");
           }
        }

        if (B != 0) {
            for (int i = 0; i < B; i++) {
                sb.append("b");
            }
        }

        return sb.toString();
    }

}
