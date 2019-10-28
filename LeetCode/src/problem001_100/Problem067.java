package problem001_100;

public class Problem067 {

    private String appendPrefixZeros(String str, int zeroCount) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        while ((zeroCount--) > 0) {
            sb.append(0);
        }

        return sb.reverse().toString();
    }

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        // 补前导0,让a和b位数相同
        if (aLen < bLen) {
            a = appendPrefixZeros(a, bLen - aLen);
        } else if (bLen < aLen) {
            b = appendPrefixZeros(b, aLen - bLen);
        }

        int len = a.length();

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = len - i - 1;
            char aChar = a.charAt(index);
            char bChar = b.charAt(index);

            int sum = (aChar - '0') + (bChar - '0') + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem067().addBinary("11", "1"));
        System.out.println(new Problem067().addBinary("1010", "1011"));
        System.out.println(new Problem067().addBinary("1", "1"));
        System.out.println(new Problem067().addBinary("1", "0"));
        System.out.println(new Problem067().addBinary("0", "0"));
    }
    
}
