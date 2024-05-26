package newcode;

import java.util.Scanner;

public class A {

    private static String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder();
        while ((count--) > 0) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String getAns(int len, String str) {
        char[] arr = str.toCharArray();
        int count = 0;
        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (Character.isLetter(c)) {
                if (i > 0 && Character.isDigit(arr[i - 1])) {
                    ansSb.append(repeat(c, count));
                } else {
                    ansSb.append(c);
                }
                count = 0;
            } else {
                count *= 10;
                count += c - '0';
            }
        }
        return ansSb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int len = in.nextInt();
            String str = in.next();
            System.out.println(getAns(len, str));
        }
    }

}
