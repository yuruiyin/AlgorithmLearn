package problem401_500;

public class Problem415 {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i, j;
        for (i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--, j--) {
            int bit1 = num1.charAt(i) - '0';
            int bit2 = num2.charAt(j) - '0';
            int resBit = (bit1 + bit2 + carry) % 10;
            carry = (bit1 + bit2 + carry) / 10;
            sb.append(resBit);
        }

        int maxIndex = Math.max(i, j);
        String maxLenNum;

        if (len1 >= len2) {
            maxLenNum = num1;
        } else {
            maxLenNum = num2;
        }

        for (int k = maxIndex; k >= 0; k--) {
            int bit = maxLenNum.charAt(k) - '0';
            int resBit = (bit + carry) % 10;
            carry = (bit + carry) / 10;
            sb.append(resBit);
        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

}
