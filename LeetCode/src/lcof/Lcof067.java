package lcof;

public class Lcof067 {

    private boolean isValid(char c) {
        return c == '+' || c == '-' || isNum(c);
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public int strToInt(String str) {
        String newStr = str.trim();
        char[] arr = newStr.toCharArray();
        int len = arr.length;

        if (len == 0 || !isValid(arr[0])) {
            return 0;
        }

        int sign = arr[0] == '-' ? -1 : 1;
        int ans = 0;
        if (isNum(arr[0])) {
            ans = arr[0] - '0';
        }

        for (int i = 1; i < len; i++) {
            if (!isNum(arr[i])) {
                break;
            }

            int r = arr[i] - '0';
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && r > 7)) {
                // 这里关键是r > 7，因为Integer.MAX_VALUE 值为 2147483647，最后一位是7，因此如果最后一位大于7，则说明溢出了。
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + r;
        }

        return sign * ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Lcof067().strToInt("42"));
    }

}
