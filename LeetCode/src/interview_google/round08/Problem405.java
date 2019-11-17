package interview_google.round08;

public class Problem405 {

    public String toHex(int num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int value = num % 16;
            if (value >= 10) {
                char c = (char) (value - 10 + 'a');
                sb.append(c);
            } else {
                sb.append(value);
            }
            num /= 16;
        }

        if (isNegative) {
            int leftZeroCount = 8 - sb.length();
            while ((leftZeroCount--) > 0) {
                sb.append(0);
            }

            StringBuilder newSb = sb.reverse();
            StringBuilder ansSb = new StringBuilder();
            // 取反加1
            for (int i = 0; i < newSb.length(); i++) {
                char c = newSb.charAt(i);
                if (c >= 'a' && c <= 'f') {
                    ansSb.append(5 - (c - 'a'));
                } else {
                    int value = 15 - (c - '0');
                    if (value >= 10) {
                        char tmpC = (char) (value - 10 + 'a');
                        ansSb.append(tmpC);
                    } else {
                        ansSb.append(value);
                    }
                }
            }

            // 加1
            char[] arr = ansSb.toString().toCharArray();
            int carry = 1;
            for (int i = arr.length - 1; i >= 0; i--) {
                int tmpNum = arr[i] + carry;
                if (tmpNum <= 'f') {
                    char newC = tmpNum == '9' + 1 ? 'a' : (char) tmpNum;
                    arr[i] = newC;
                    carry = 0;
                    break;
                }

                arr[i] = '0';
                carry = 1;
            }

            if (carry == 1) {
                arr[0] = '8';
            }

            StringBuilder ansSb1 = new StringBuilder();
            for (char c : arr) {
                ansSb1.append(c);
            }
            return ansSb1.length() == 0 ? "0" : ansSb1.toString();
        }

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem01().toHex(-1));
//        System.out.println(new Problem01().toHex(-111110));
        System.out.println(new Problem405().toHex(-2147483648));
    }
    
}
