package problem1_100;

public class Problem043 {

    private String getReversedStr(String str) {
        StringBuilder resSb1 = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            resSb1.append(str.charAt(i));
        }

        return resSb1.toString();
    }

    private String add(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int index1 = len1 - 1;
        int index2 = len2 - 1;
        StringBuilder resSb = new StringBuilder();
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            char c1 = index1 >= 0 ? num1.charAt(index1) : '0';
            char c2 = index2 >= 0 ? num2.charAt(index2) : '0';
            int i1 = c1 - '0';
            int i2 = c2 - '0';
            int value = (i1 + i2 + carry) % 10;
            carry = (i1 + i2 + carry) / 10;
            resSb.append(value);
            index1--;
            index2--;
        }

        if (carry == 1) {
            resSb.append('1');
        }

        // 倒置
        return getReversedStr(resSb.toString());
    }

    /**
     * 个位数乘以一个大整数
     */
    private String singleMultiply(String numStr, char c) {
        int carry = 0; //乘法进位
        int singleNum = c - '0';
        StringBuilder resSb = new StringBuilder();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int curNum = numStr.charAt(i) - '0';
            int res = (singleNum * curNum + carry) % 10;
            carry = (singleNum * curNum + carry) / 10;
            resSb.append(res);
        }

        if (carry != 0) {
            resSb.append(carry);
        }

        return getReversedStr(resSb.toString());
    }

    /**
     * 往数字字符串右边增加n个0，即数字按数量级放大
     */
    private String insertZerosToRight(String str, int n) {
        StringBuilder sb = new StringBuilder(str);
        while (n-- > 0) {
            sb.append('0');
        }

        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String sum = "0";
        int count = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            char c2 = num2.charAt(i);
            // 那c2与num1相乘
            String res = singleMultiply(num1, c2);
            String res1 = insertZerosToRight(res, count);
            sum = add(sum, res1);
            count++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem043().multiply("2", "3"));
        System.out.println(new Problem043().multiply("123", "456"));
        System.out.println(new Problem043().multiply("9133", "0"));
    }

}
