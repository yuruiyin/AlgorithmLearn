package problem1301_1400;

public class Problem1309 {

    private boolean isNum(char c) {
        return c >= '1' && c <= '9';
    }

    public String freqAlphabets(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; ) {
            if (isNum(arr[i])) {
                if (i >= len - 2 || arr[i+2] != '#') {
                    sb.append((char)(arr[i] - '1' + 'a'));
                    i++;
                } else if (arr[i+2] == '#') {
                    int num = (arr[i] - '0') * 10 + arr[i+1] - '0';
                    sb.append((char) (num - 10 + 'j'));
                    i += 3;
                }
            }
        }

        return sb.toString();
    }

}
