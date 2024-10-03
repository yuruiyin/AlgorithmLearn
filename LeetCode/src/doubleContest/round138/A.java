package doubleContest.round138;

import java.util.Map;

public class A {

    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while (num1 > 0 || num2 > 0 || num3 > 0) {
            int mod1 = num1 % 10;
            int mod2 = num2 % 10;
            int mod3 = num3 % 10;
            int min = Math.min(Math.min(mod1, mod2), mod3);
            sb.append(min);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }

        String newSb = sb.reverse().toString();
        int ansNew = Integer.parseInt(newSb);
        return ansNew;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
