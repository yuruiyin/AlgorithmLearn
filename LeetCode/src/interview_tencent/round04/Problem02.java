package interview_tencent.round04;

import java.util.HashMap;
import java.util.Map;

public class Problem02 {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        if (num >= 1000) {
            int n = num / 1000;
            while ((n--) > 0) {
                sb.append("M");
            }
            num = num % 1000;
        }

        int value = 100;

        while (num > 0) {
            int n = num / value;
            if (n < 1) {
                value /= 10;
                continue;
            }

            if (n == 9 || n == 4) {
                sb.append(map.get(n * value));
            } else if (n >= 5) {
                sb.append(map.get(5 * value));
                for (int i = 0; i < n - 5; i++) {
                    sb.append(map.get(value));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(map.get(value));
                }
            }

            num %= value;
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem02().intToRoman(3));
        System.out.println(new Problem02().intToRoman(4));
        System.out.println(new Problem02().intToRoman(9));
        System.out.println(new Problem02().intToRoman(58));
        System.out.println(new Problem02().intToRoman(1994));

    }
    
}
