package interview_google.round02;

public class Problem03 {

    public int longestDecomposition(String text) {
        int left = 0;
        int right = text.length() - 1;

        int count = 0;

        while (left < right) {
            char leftChar = text.charAt(left);

            int mid = (left + right) >> 1;
            int j;
            boolean isFound = false;
            for (j = right; j > mid; j--) {
                if (text.charAt(j) == leftChar) {
                    int len = right - j + 1;
                    String rightStr = text.substring(j, j + len);
                    String leftStr = text.substring(left, left + len);

                    if (leftStr.equals(rightStr)) {
                        count += 2;
                        left = left + len;
                        right = right - len;
                        isFound = true;
                        break;
                    }
                }
            }

            if (!isFound) {
                return 1 + count;
            }

        }

        if (left == right) {
            count++;
        }

        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem03().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(new Problem03().longestDecomposition("merchant"));
        System.out.println(new Problem03().longestDecomposition("antaprezatepzapreanta"));
        System.out.println(new Problem03().longestDecomposition("aaa"));
        System.out.println(new Problem03().longestDecomposition("aa"));
        System.out.println(new Problem03().longestDecomposition("ab"));
        System.out.println(new Problem03().longestDecomposition("a"));
        System.out.println(new Problem03().longestDecomposition("vwsuvmbwknmnvwsuvmbwk"));

    }
    
}
