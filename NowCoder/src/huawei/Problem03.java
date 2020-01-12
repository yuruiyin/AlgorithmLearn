package huawei;

import java.util.Scanner;

public class Problem03 {

    private static int getValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }

        return 10 + c - 'A';
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.next();
            String numStr = str.substring(2);

            int num = 0;
            int len = numStr.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = numStr.charAt(i);
                num += Math.pow(16, len - 1 - i) * getValue(c);
            }
            
            System.out.println(num);
        }
    }
    
}
